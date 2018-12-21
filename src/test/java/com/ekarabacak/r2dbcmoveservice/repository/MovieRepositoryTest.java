package com.ekarabacak.r2dbcmoveservice.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import reactor.test.StepVerifier;

@SpringBootTest
@RunWith(SpringRunner.class)
public class MovieRepositoryTest {

    private MovieRepository movieRepository;

    public MovieRepositoryTest(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Test
    public void t1() {
        StepVerifier.create(movieRepository.findAllBy()).expectComplete();
    }
}
