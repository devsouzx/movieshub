package com.devsouzx.movieshub.resources;

import com.devsouzx.movieshub.domain.Movie;
import com.devsouzx.movieshub.dto.MovieDTO;
import com.devsouzx.movieshub.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
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

    @PostMapping
    public ResponseEntity<Movie> insert(@RequestBody MovieDTO movieDTO, UriComponentsBuilder uriComponentsBuilder) {
        Movie movie = movieService.fromDTO(movieDTO);
        movie = movieService.insert(movie);
        URI uri = uriComponentsBuilder.path("/{id}").buildAndExpand(movie.getId()).toUri();
        return ResponseEntity.created(uri).body(movie);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        movieService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
