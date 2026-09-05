package com.michaelweinberg.moviesv2.web;


import com.michaelweinberg.moviesv2.model.Review;
import com.michaelweinberg.moviesv2.model.service.ReviewService;
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
@Tag(name = "Reviews", description = "Movies reviews")
@RequestMapping("/reviews")
public class ReviewController {

    private ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping(path = "/{movieId}")
    @Operation(summary = "Lookup review for a movie")
    public List<Review> getReviewsByMovieId(@PathVariable Long movieId) { return this.reviewService.getAllReviewsForMovie(movieId); }
}
