package com.moviesCatalog.movie_catalog_api.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "reviews")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, name = "author")
    private String author;

    @Column(nullable = false, name = "comment")
    private String comment;

    @Column(nullable = false, name = "rating")
    private Integer rating;

    @ManyToOne // Много рецензий к одному фильму
    @JoinColumn(name = "movie_id")
    private Movie movie;
}