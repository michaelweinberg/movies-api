package com.michaelweinberg.moviesv2.repository;

import com.michaelweinberg.moviesv2.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findReviewsByMovieId(Long movieId);
}
