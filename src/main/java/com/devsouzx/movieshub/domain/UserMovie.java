package com.devsouzx.movieshub.domain;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class UserMovie {
    private String userId;
    private String movieId;
    private Date watchedDate;
}
