package com.michaelweinberg.moviesv2.model.service;

import com.michaelweinberg.moviesv2.model.Review;
import com.michaelweinberg.moviesv2.repository.MovieRepository;
import com.michaelweinberg.moviesv2.repository.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;

    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public List<Review> getAllReviewsForMovie(Long id) {
        List<Review> reviews = this.reviewRepository.findReviewsByMovieId(id);
        if (reviews.isEmpty()) {
            return Collections.emptyList();
        } else {
            return reviews;
        }
    }
}
