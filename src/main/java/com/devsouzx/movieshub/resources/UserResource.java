package com.devsouzx.movieshub.resources;

import com.devsouzx.movieshub.domain.Movie;
import com.devsouzx.movieshub.domain.User;
import com.devsouzx.movieshub.domain.UserMovie;
import com.devsouzx.movieshub.dto.UserDTO;
import com.devsouzx.movieshub.repositories.UserMovieRepository;
import com.devsouzx.movieshub.services.MovieService;
import com.devsouzx.movieshub.services.UserMovieService;
import com.devsouzx.movieshub.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class UserResource {
    @Autowired
    private UserService userService;

    @Autowired
    private UserMovieService userMovieService;

    @Autowired
    private MovieService movieService;

    @GetMapping
    public ResponseEntity<List<User>> findUsers() {
        List<User> users = userService.findAll();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findUser(@PathVariable String id) {
        User user = userService.findById(id);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/{id}/movies")
    public ResponseEntity<List<Movie>> findMovies(@PathVariable String id) {
        List<UserMovie> userMovies = userMovieService.findByUserId(id);
        List<Movie> movies = userMovies.stream()
                .map(userMovie -> movieService.findById(userMovie.getMovieId()))
                .filter(Objects::nonNull)
                .toList();
        return ResponseEntity.ok(movies);
    }

    @PostMapping
    public ResponseEntity<User> insert(@RequestBody UserDTO userDTO, UriComponentsBuilder uriComponentsBuilder) {
        User user = userService.fromDTO(userDTO);
        user = userService.insert(user);
        URI uri = uriComponentsBuilder.path("/{id}").buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(uri).body(user);
    }

    @PostMapping("/{id}/movies/{movieId}")
    public ResponseEntity<Void> insert(@PathVariable String id, @PathVariable String movieId,UriComponentsBuilder uriComponentsBuilder) {
        UserMovie userMovie = userMovieService.addMovieToUser(id, movieId);
        URI uri = uriComponentsBuilder.path("/{id}").buildAndExpand(userMovie.getUserId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> update(@PathVariable String id, @RequestBody User user) {
        user = userService.update(id, user);
        return ResponseEntity.ok(user);
    }
}
