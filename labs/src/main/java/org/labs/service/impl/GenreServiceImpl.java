package org.labs.service.impl;

import lombok.AllArgsConstructor;
import org.labs.domain.Genre;
import org.labs.dto.genre.GenreRequestDto;
import org.labs.exception.GenreNotFoundException;
import org.labs.mapper.GenreMapper;
import org.labs.repository.GenreRepository;
import org.labs.repository.entity.GenreEntity;
import org.labs.service.GenreService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class GenreServiceImpl implements GenreService {
    private final GenreRepository genreRepository;
    private final GenreMapper genreMapper;

    @Override
    @Transactional
    public Genre createGenre(GenreRequestDto genreRequestDto) {
        GenreEntity genre = GenreEntity.builder()
                .title(genreRequestDto.getTitle())
                .build();

        try {
            return genreMapper.toGenre(genreRepository.save(genre));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    @Transactional
    public Genre updateGenre(UUID id, GenreRequestDto genreRequestDto) {
        Genre existGenre = getGenreById(id);

        existGenre.setTitle(genreRequestDto.getTitle());

        try {
            return genreMapper.toGenre(genreRepository.save(genreMapper.toGenreEntity(existGenre)));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public Genre getGenreById(UUID id) {
        return genreMapper.toGenre(genreRepository.findById(id).orElseThrow(() -> new GenreNotFoundException(id.toString())));
    }

    @Override
    @Transactional(readOnly = true)
    public List<Genre> getGenres() {
        return genreMapper.toGenres(genreRepository.findAll());
    }

    @Override
    @Transactional
    public void deleteGenre(UUID id) {
        try {
            genreRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
