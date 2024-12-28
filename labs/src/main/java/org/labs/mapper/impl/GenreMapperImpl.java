package org.labs.mapper.impl;

import lombok.AllArgsConstructor;
import org.labs.domain.Genre;
import org.labs.dto.genre.GenreResponseDto;
import org.labs.mapper.GenreMapper;
import org.labs.repository.entity.GenreEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class GenreMapperImpl implements GenreMapper {

    @Override
    public Genre toGenre(GenreEntity genreEntity) {
        return Genre.builder()
                .id(genreEntity.getId())
                .title(genreEntity.getTitle())
                .build();
    }

    @Override
    public List<Genre> toGenres(Iterable<GenreEntity> genreEntities) {
        return ((List<GenreEntity>) genreEntities).stream()
                .map(this::toGenre)
                .collect(Collectors.toList());
    }

    @Override
    public GenreResponseDto toGenreResponseDto(Genre genre) {
        return GenreResponseDto.builder()
                .id(genre.getId().toString())
                .title(genre.getTitle())
                .build();
    }

    @Override
    public List<GenreResponseDto> toGenreResponseDtos(List<Genre> genres) {
        return genres.stream().map(this::toGenreResponseDto).collect(Collectors.toList());
    }

    @Override
    public GenreEntity toGenreEntity(Genre genre) {
        return GenreEntity.builder()
                .id(genre.getId())
                .title(genre.getTitle())
                .build();
    }
}
