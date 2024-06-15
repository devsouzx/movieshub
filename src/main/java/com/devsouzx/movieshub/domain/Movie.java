package com.devsouzx.movieshub.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Document
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Movie {
    @Id
    private String id;
    private String title;
    private String description;
    private String director;
    private Date releaseDate;
    private Integer runtime;
    private List<String> genders = new ArrayList<>();
}
