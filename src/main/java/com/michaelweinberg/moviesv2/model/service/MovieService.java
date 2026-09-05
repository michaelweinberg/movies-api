package com.michaelweinberg.moviesv2.model.service;

import com.michaelweinberg.moviesv2.exception.MovieNotFoundException;
import com.michaelweinberg.moviesv2.model.Movie;
import com.michaelweinberg.moviesv2.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) { this.movieRepository = movieRepository; }

    public List<Movie> getAllMovies() {
        return this.movieRepository.findAll();
    }

    public Movie getMovieById(Long id) {
        return this.movieRepository.findById(id)
                .orElseThrow(() -> new MovieNotFoundException(id));
    }
}
