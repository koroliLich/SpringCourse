package org.labs.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.labs.dto.genre.GenreRequestDto;
import org.labs.dto.genre.GenreResponseDto;
import org.labs.mapper.GenreMapper;
import org.labs.service.GenreService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/genres")
@AllArgsConstructor
public class GenreController {
    private final GenreService genreService;
    private final GenreMapper genreMapper;

    @PostMapping
    public ResponseEntity<GenreResponseDto> createGenre(@RequestBody @Valid GenreRequestDto genreRequestDto) {
        return ResponseEntity.ok(genreMapper.toGenreResponseDto(genreService.createGenre(genreRequestDto)));
    }

    @GetMapping
    public ResponseEntity<List<GenreResponseDto>> getGenres() {
        return ResponseEntity.ok(genreMapper.toGenreResponseDtos(genreService.getGenres()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<GenreResponseDto> getGenreById(@PathVariable UUID id) {
        return ResponseEntity.ok(genreMapper.toGenreResponseDto(genreService.getGenreById(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<GenreResponseDto> updateGenre(@PathVariable UUID id, @RequestBody @Valid GenreRequestDto genreRequestDto) {
        return ResponseEntity.ok(genreMapper.toGenreResponseDto(genreService.updateGenre(id, genreRequestDto)));
    }

    @DeleteMapping("/{id}")
    public void deleteGenreById(@PathVariable UUID id) {
        genreService.deleteGenre(id);
    }
}
