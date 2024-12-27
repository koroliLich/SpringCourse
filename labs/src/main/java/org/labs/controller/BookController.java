package org.labs.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.labs.dto.BookRequestDto;
import org.labs.dto.BookResponseDto;
import org.labs.mapper.BookMapper;
import org.labs.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/books")
@AllArgsConstructor
@Validated
public class BookController {
    private final BookService bookService;
    private final BookMapper bookMapper;

    @PostMapping
    public ResponseEntity<BookResponseDto> createBook(@RequestBody @Valid BookRequestDto bookRequestDto) {
        return ResponseEntity.ok(bookMapper.toBookResponseDto(bookService.createBook(bookRequestDto)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookResponseDto> updateBook(@PathVariable UUID id, @RequestBody @Valid BookRequestDto bookRequestDto) {
        return ResponseEntity.ok(bookMapper.toBookResponseDto(bookService.updateBook(id, bookRequestDto)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookResponseDto> getBookById(@PathVariable UUID id) {
        return ResponseEntity.ok(bookMapper.toBookResponseDto(bookService.getBookById(id)));
    }

    @GetMapping
    public ResponseEntity<List<BookResponseDto>> getAllBooks(@RequestParam(defaultValue = "10") Long limit,
                                                             @RequestParam(defaultValue = "0") Long offset) {
        return ResponseEntity.ok(bookMapper.toBookResponseDtoList(bookService.getAllBooks(limit, offset)));
    }

    @GetMapping("/by-author")
    public ResponseEntity<List<BookResponseDto>> getBooksByAuthor(@RequestParam String author,
                                                                  @RequestParam(defaultValue = "10") Long limit,
                                                                  @RequestParam(defaultValue = "0") Long offset) {
        return ResponseEntity.ok(bookMapper.toBookResponseDtoList(bookService.getAllBooksByAuthor(author, limit, offset)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable UUID id) {
        return ResponseEntity.ok(bookService.deleteBook(id));
    }
}
