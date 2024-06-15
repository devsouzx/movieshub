package com.devsouzx.movieshub.config;

import com.devsouzx.movieshub.domain.User;
import com.devsouzx.movieshub.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class TestConfig implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        userRepository.deleteAll();
        User dallyla = new User(null, "Dallyla Lima", "dallyla@gmail.com");
        User camilly = new User(null, "Camilly Victoria", "camilly@gmail.com");
        User ellen = new User(null, "Ellen Kayene", "ellen@gmail.com");

        userRepository.saveAll(Arrays.asList(dallyla, camilly, ellen));
    }
}
