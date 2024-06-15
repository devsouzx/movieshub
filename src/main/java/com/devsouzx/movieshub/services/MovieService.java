package com.devsouzx.movieshub.services;

import com.devsouzx.movieshub.domain.Movie;
import com.devsouzx.movieshub.domain.User;
import com.devsouzx.movieshub.repositories.MovieRepository;
import com.devsouzx.movieshub.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;

    public List<Movie> findAll() {
        return movieRepository.findAll();
    }

    public Movie findById(String id) {
        Optional<Movie> movie = movieRepository.findById(id);
        return movie.orElseThrow(() -> new ObjectNotFoundException("Movie not Found"));
    }
}
