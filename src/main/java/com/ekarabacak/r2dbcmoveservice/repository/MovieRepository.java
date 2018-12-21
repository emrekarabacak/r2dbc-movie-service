package com.ekarabacak.r2dbcmoveservice.repository;

import com.ekarabacak.r2dbcmoveservice.model.Movie;
import org.springframework.data.r2dbc.repository.query.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

public interface MovieRepository extends ReactiveCrudRepository<Movie, Long> {

    @Query("select * from movie")
    Flux<Movie> findAllBy();
}
