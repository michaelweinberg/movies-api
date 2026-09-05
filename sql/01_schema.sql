-- Schema for the moviesv2 application.
-- Maps to com.michaelweinberg.moviesv2.model.Movie and .Review
--
-- Usage: psql -d moviesv2 -f sql/01_schema.sql

DROP TABLE IF EXISTS reviews;
DROP TABLE IF EXISTS movies;

CREATE TABLE movies (
    id    BIGSERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    genre VARCHAR(100)
);

CREATE TABLE reviews (
    id       BIGSERIAL PRIMARY KEY,
    movie_id BIGINT NOT NULL REFERENCES movies (id) ON DELETE CASCADE,
    rating   INTEGER NOT NULL CHECK (rating BETWEEN 1 AND 10),
    comment  TEXT
);

CREATE INDEX idx_reviews_movie_id ON reviews (movie_id);
