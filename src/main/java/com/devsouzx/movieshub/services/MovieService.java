package com.devsouzx.movieshub.services;

import com.devsouzx.movieshub.domain.Movie;
import com.devsouzx.movieshub.domain.User;
import com.devsouzx.movieshub.dto.MovieDTO;
import com.devsouzx.movieshub.dto.UserDTO;
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

    public Movie insert(Movie movie) {
        return movieRepository.save(movie);
    }

    public Movie fromDTO(MovieDTO movieDTO) {
        return new Movie(movieDTO.getId(), movieDTO.getTitle(), movieDTO.getDescription(), movieDTO.getDirector(), movieDTO.getReleaseDate(), movieDTO.getRuntime(), movieDTO.getGenders());
    }

    public void delete(String id) {
        movieRepository.delete(findById(id));
    }

    public Movie update(String id, Movie movie) {
        Movie entity = findById(id);
        updateData(entity, movie);
        return movieRepository.save(entity);
    }

    public void updateData(Movie entity, Movie movie) {
        entity.setTitle(movie.getTitle());
        entity.setDescription(movie.getDescription());
        entity.setDirector(movie.getDirector());
        entity.setReleaseDate(movie.getReleaseDate());
        entity.setRuntime(movie.getRuntime());
        entity.setGenders(movie.getGenders());
    }
}
