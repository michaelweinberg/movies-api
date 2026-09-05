package com.michaelweinberg.moviesv2.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="reviews")
@Data
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

//    @Column(name = "movie_id")
//    private Long movieId;
    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;

    @Column(name = "rating")
    private int rating;

    @Column(name = "comment")
    private String comment;
}
