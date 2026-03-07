package com.moviesCatalog.movie_catalog_api.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "directors")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Director {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // SERIAL / AUTO INCREMENT
    private Long id;

    @Column(nullable = false, name = "name")
    private String name;

    @Column(nullable = false, name = "birthYear")
    private Integer birthYear;
}