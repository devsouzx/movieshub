package com.devsouzx.movieshub.resources;

import com.devsouzx.movieshub.domain.User;
import com.devsouzx.movieshub.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserResource {
    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> findUsers() {
        List<User> users = userService.findAll();
        return ResponseEntity.ok(users);
    }
}
