# syntax=docker/dockerfile:1

# ---- Build stage ----
FROM maven:3.9-eclipse-temurin-21 AS build
WORKDIR /build

# Resolve dependencies first so they stay cached when only sources change.
COPY pom.xml .
RUN --mount=type=cache,target=/root/.m2 mvn -B dependency:go-offline

COPY src ./src
RUN --mount=type=cache,target=/root/.m2 mvn -B clean package -DskipTests

# Split the fat jar into layers so Docker can cache dependencies
# separately from application code.
RUN java -Djarmode=tools -jar target/*.jar extract --layers --launcher --destination extracted

# ---- Runtime stage ----
FROM eclipse-temurin:21-jre AS runtime
WORKDIR /app

RUN apt-get update \
 && apt-get install -y --no-install-recommends curl \
 && rm -rf /var/lib/apt/lists/*

RUN groupadd --system spring && useradd --system --gid spring spring
USER spring:spring

COPY --from=build --chown=spring:spring /build/extracted/dependencies/ ./
COPY --from=build --chown=spring:spring /build/extracted/spring-boot-loader/ ./
COPY --from=build --chown=spring:spring /build/extracted/snapshot-dependencies/ ./
COPY --from=build --chown=spring:spring /build/extracted/application/ ./

ENV JAVA_OPTS=""
ENV SERVER_PORT=8080
EXPOSE 8080

# POSTGRES_URL, POSTGRES_USERNAME and POSTGRES_PASSWORD are required at runtime
# (see src/main/resources/application.yaml).

HEALTHCHECK --interval=30s --timeout=3s --start-period=40s --retries=3 \
  CMD curl -fsS http://localhost:${SERVER_PORT}/actuator/health || exit 1

ENTRYPOINT ["sh", "-c", "exec java $JAVA_OPTS -XX:MaxRAMPercentage=75 org.springframework.boot.loader.launch.JarLauncher"]
