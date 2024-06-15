package com.devsouzx.movieshub.resources;

import com.devsouzx.movieshub.domain.Movie;
import com.devsouzx.movieshub.domain.User;
import com.devsouzx.movieshub.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieResource {
    @Autowired
    private MovieService movieService;

    @GetMapping
    public ResponseEntity<List<Movie>> findAll() {
        List<Movie> movies = movieService.findAll();
        return ResponseEntity.ok(movies);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Movie> findUser(@PathVariable String id) {
        Movie movie = movieService.findById(id);
        return ResponseEntity.ok(movie);
    }
}
