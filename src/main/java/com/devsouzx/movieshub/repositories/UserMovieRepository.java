package com.devsouzx.movieshub.repositories;

import com.devsouzx.movieshub.domain.UserMovie;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UserMovieRepository extends MongoRepository<UserMovie, String> {
    List<UserMovie> findByUserId(String userId);
}
