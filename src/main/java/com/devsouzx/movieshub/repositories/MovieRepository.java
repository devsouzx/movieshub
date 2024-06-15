package com.devsouzx.movieshub.repositories;

import com.devsouzx.movieshub.domain.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MovieRepository extends MongoRepository<Movie, String> {
}
