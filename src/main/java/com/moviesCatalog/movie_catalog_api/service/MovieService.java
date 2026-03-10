package com.moviesCatalog.movie_catalog_api.service;

import com.moviesCatalog.movie_catalog_api.model.Actor;
import com.moviesCatalog.movie_catalog_api.model.Movie;
import com.moviesCatalog.movie_catalog_api.repository.ActorRepository;
import com.moviesCatalog.movie_catalog_api.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service // аннотация, показывающая что это сервисный компонент
public class MovieService {

    private final MovieRepository movieRepository; // Это ссылка на Repository, который работает с базой данных.
    private final ActorRepository actorRepository;
    // Конструктор
    public MovieService(MovieRepository movieRepository, ActorRepository actorRepository) {
        this.movieRepository = movieRepository;
        this.actorRepository = actorRepository;
    } // Spring автоматически передаст Repository - Dependency Injection

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    } // SELECT * FROM movies

    public Movie getMovieById(Long id) {
        return movieRepository.findById(id).orElse(null);
    } // SELECT * FROM movies WHERE id = ?

    public Movie saveMovie(Movie movie) {
        List<Actor> actorsFromDb = new ArrayList<>();

        for (Actor actor : movie.getActors()) {

            Actor dbActor = actorRepository.findById(actor.getId())
                    .orElseThrow(() -> new RuntimeException("Actor not found"));

            actorsFromDb.add(dbActor);
        }

        movie.setActors(actorsFromDb);
        return movieRepository.save(movie);
    } // INSERT INTO movies ...

    public void deleteMovie(Long id) {

        movieRepository.deleteById(id);
    } // DELETE FROM movies WHERE id = ?
}