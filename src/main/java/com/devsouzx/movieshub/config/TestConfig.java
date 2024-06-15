package com.devsouzx.movieshub.config;

import com.devsouzx.movieshub.domain.Movie;
import com.devsouzx.movieshub.domain.User;
import com.devsouzx.movieshub.repositories.MovieRepository;
import com.devsouzx.movieshub.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Configuration
public class TestConfig implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MovieRepository movieRepository;

    @Override
    public void run(String... args) throws Exception {
        userRepository.deleteAll();
        movieRepository.deleteAll();

        User dallyla = new User(null, "Dallyla Lima", "dallyla@gmail.com");
        User camilly = new User(null, "Camilly Victoria", "camilly@gmail.com");
        User ellen = new User(null, "Ellen Kayene", "ellen@gmail.com");

        userRepository.saveAll(Arrays.asList(dallyla, camilly, ellen));

        Movie movie1 = new Movie(
                null,
                "O Senhor dos Anéis: A Sociedade do Anel",
                "Um hobbit é chamado para uma aventura épica para destruir o Um Anel.",
                "Peter Jackson",
                new Date(2001, 12, 19),
                178,
                new ArrayList<>(List.of("Fantasia", "Aventura"))
        );

        Movie movie2 = new Movie(
                null,
                "O Poderoso Chefão",
                "A história da família Corleone, um império do crime organizado.",
                "Francis Ford Coppola",
                new Date(1972, 3, 14),
                175,
                new ArrayList<>(List.of("Drama", "Crime"))
        );

        Movie movie3 = new Movie(
                null,
                "Pulp Fiction",
                "Uma série de histórias interligadas que se passa no submundo de Los Angeles.",
                "Quentin Tarantino",
                new Date(1994, 10, 14),
                154,
                new ArrayList<>(List.of("Crime", "Drama"))
        );

        movieRepository.saveAll(Arrays.asList(movie1, movie2, movie3));
    }
}
