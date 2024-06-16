package com.devsouzx.movieshub.dto;

import com.devsouzx.movieshub.domain.Movie;
import com.devsouzx.movieshub.domain.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class MovieDTO implements Serializable {
    @Id
    private String id;
    private String title;
    private String description;
    private String director;
    private Date releaseDate;
    private Date watchedDate;
    private Integer runtime;
    private List<String> genders = new ArrayList<>();

    public MovieDTO(Movie movie) {
        id = movie.getId();
        title = movie.getTitle();
        description = movie.getDescription();
        director = movie.getDirector();
        releaseDate = movie.getReleaseDate();
        runtime = movie.getRuntime();
        genders = movie.getGenders();
    }
}
