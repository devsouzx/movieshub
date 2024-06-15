package com.devsouzx.movieshub.repositories;

import com.devsouzx.movieshub.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
}
