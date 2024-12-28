package org.labs.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.labs.dto.author.AuthorRequestDto;
import org.labs.dto.author.AuthorResponseDto;
import org.labs.mapper.AuthorMapper;
import org.labs.service.AuthorService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/authors")
@AllArgsConstructor
@Validated
public class AuthorController {
    private final AuthorService authorService;
    private final AuthorMapper authorMapper;

    @PostMapping
    public ResponseEntity<AuthorResponseDto> createAuthor(@RequestBody @Valid AuthorRequestDto authorRequestDto) {
        return ResponseEntity.ok(authorMapper.toAuthorResponseDto(authorService.createAuthor(authorRequestDto)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AuthorResponseDto> updateAuthor(@PathVariable UUID id, @RequestBody @Valid AuthorRequestDto authorRequestDto) {
        return ResponseEntity.ok(authorMapper.toAuthorResponseDto(authorService.updateAuthor(id, authorRequestDto)));
    }

    @DeleteMapping("/{id}")
    public void deleteAuthor(@PathVariable UUID id) {
        authorService.deleteAuthor(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AuthorResponseDto> getAuthorById(@PathVariable UUID id) {
        return ResponseEntity.ok(authorMapper.toAuthorResponseDto(authorService.getAuthorById(id)));
    }

    @GetMapping
    public ResponseEntity<List<AuthorResponseDto>> getAllAuthors() {
        return ResponseEntity.ok(authorMapper.toAuthorResponseDtos(authorService.getAuthors()));
    }
}
