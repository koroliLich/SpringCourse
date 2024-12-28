package org.labs.service;

import org.labs.domain.Genre;
import org.labs.dto.genre.GenreRequestDto;

import java.util.List;
import java.util.UUID;

public interface GenreService {
    Genre createGenre(GenreRequestDto genreRequestDto);
    Genre updateGenre(UUID id, GenreRequestDto genreRequestDto);
    Genre getGenreById(UUID id);
    List<Genre> getGenres();
    void deleteGenre(UUID id);
}
