package com.michaelweinberg.moviesv2.web;

import com.michaelweinberg.moviesv2.model.Movie;
import com.michaelweinberg.moviesv2.model.service.MovieService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@Tag(name = "Movies", description = "Available movies")
@RequestMapping("/movies")
public class MovieController {

    private MovieService movieService;

    public MovieController(MovieService movieService) { this.movieService = movieService; }

    @GetMapping
    @Operation(summary = "Lookup All Movies")
    public List<Movie> getAllMovies() {
        return this.movieService.getAllMovies();
    }

    @GetMapping(path = "/{id}")
    @Operation(summary = "Lookup a single movie")
    public Movie getMovieById(@PathVariable Long id) {
        return this.movieService.getMovieById(id);
    }

}
