package com.ekarabacak.r2dbcmoveservice.controller;

import com.ekarabacak.r2dbcmoveservice.model.Movie;
import com.ekarabacak.r2dbcmoveservice.repository.MovieRepository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/movies")
public class MovieController {

    private MovieRepository movieRepository;

    public MovieController(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @GetMapping
    Flux<Movie> findAllMovies() {
        return movieRepository.findAll();
    }

    @GetMapping("/{id}")
    Mono<Movie> findById(@PathVariable Long id) {
        return movieRepository.findById(id);
    }

    @DeleteMapping("/{id}")
    Mono<Void> deleteMovid(@PathVariable  Long id) {
        return movieRepository.deleteById(id).then();
    }

    @PostMapping
    Mono<Movie> createMovie(@RequestBody Movie movie) {
        return movieRepository.save(movie);
    }

    @PutMapping("/{id}")
    Mono<Movie> updateMovie(@RequestBody Movie updatedMovie, @PathVariable Long id) {

        return movieRepository
                .findById(id)
                .map(existingMovie -> new Movie(existingMovie.getId(), updatedMovie.getName()))
                .flatMap(newMovie -> movieRepository.save(newMovie));
    }
}
