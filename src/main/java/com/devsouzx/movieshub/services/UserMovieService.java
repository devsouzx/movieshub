package com.devsouzx.movieshub.services;

import com.devsouzx.movieshub.domain.UserMovie;
import com.devsouzx.movieshub.repositories.UserMovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserMovieService {
    @Autowired
    private UserMovieRepository userMovieRepository;

    public void addMovieToUser(String userId, String movieId) {
        UserMovie userMovie = new UserMovie(userId, movieId);
        userMovieRepository.save(userMovie);
    }

    public List<UserMovie> findByUserId(String id) {
        List<UserMovie> userMovies = userMovieRepository.findByUserId(id);
        return userMovies;
    }
}
