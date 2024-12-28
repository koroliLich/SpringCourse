package org.labs.mapper;

import org.labs.domain.Genre;
import org.labs.dto.genre.GenreResponseDto;
import org.labs.repository.entity.GenreEntity;

import java.util.List;

public interface GenreMapper {
    Genre toGenre(GenreEntity genreEntity);
    List<Genre> toGenres(Iterable<GenreEntity> genreEntities);
    GenreResponseDto toGenreResponseDto(Genre genre);
    List<GenreResponseDto> toGenreResponseDtos(List<Genre> genres);
    GenreEntity toGenreEntity(Genre genre);
}
