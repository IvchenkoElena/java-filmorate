package ru.yandex.practicum.filmorate.model;

import lombok.Data;

import java.time.Instant;


/**
 * Film.
 */
@Data
public class Film {
    private Integer id;
    private String name;
    private String description;
    private Instant releaseDate;
    private Integer duration;



}
