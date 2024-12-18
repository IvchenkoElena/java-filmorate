package ru.yandex.practicum.filmorate.storage;

import ru.yandex.practicum.filmorate.model.Film;
import ru.yandex.practicum.filmorate.model.Genre;

import java.util.HashSet;
import java.util.List;

public interface GenreStorage {
    List<Genre> findAll();

    Genre getById(int id);

    HashSet<Genre> getGenresByFilmId(int id);

    void load(List<Film> films);
}
