package com.devsouzx.movieshub.services;

import com.devsouzx.movieshub.domain.Movie;
import com.devsouzx.movieshub.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;

    public List<Movie> findAll() {
        return movieRepository.findAll();
    }
}
