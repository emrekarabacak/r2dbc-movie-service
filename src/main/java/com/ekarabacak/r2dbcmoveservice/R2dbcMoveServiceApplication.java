package com.ekarabacak.r2dbcmoveservice;

import com.ekarabacak.r2dbcmoveservice.model.Movie;
import com.ekarabacak.r2dbcmoveservice.repository.MovieRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;
import reactor.core.publisher.Flux;

@SpringBootApplication
@EnableR2dbcRepositories
public class R2dbcMoveServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(R2dbcMoveServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(MovieRepository movieRepository) {
        return args -> {
            movieRepository
                    .deleteAll()
                    .thenMany(
                            Flux.just("Back to the future", "Matrix", "Terminator")
                                    .map(name -> new Movie(null, name))
                                    .flatMap(movieRepository::save))
                    .subscribe(System.out::println);
        };
    }
}
