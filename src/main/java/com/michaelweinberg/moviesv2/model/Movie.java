package com.michaelweinberg.moviesv2.model;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="movies")
@Data
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "genre")
    private String genre;

}
