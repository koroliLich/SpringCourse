package org.labs.mapper.impl;

import lombok.AllArgsConstructor;
import org.labs.domain.Book;
import org.labs.dto.book.BookResponseDto;
import org.labs.mapper.AuthorMapper;
import org.labs.mapper.BookMapper;
import org.labs.mapper.GenreMapper;
import org.labs.repository.entity.BookEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class BookMapperImpl implements BookMapper {
    private final GenreMapper genreMapper;
    private final AuthorMapper authorMapper;

    @Override
    public Book toBook(BookEntity bookEntity) {
        return Book.builder()
                .id(bookEntity.getId())
                .title(bookEntity.getTitle())
                .price(bookEntity.getPrice())
                .author(authorMapper.toAuthor(bookEntity.getAuthor()))
                .genre(genreMapper.toGenre(bookEntity.getGenres()))
                .description(bookEntity.getDescription())
                .build();
    }

    @Override
    public List<Book> toBooks(List<BookEntity> bookEntities) {
        return bookEntities.stream().map(this::toBook).collect(Collectors.toList());
    }

    @Override
    public BookResponseDto toBookResponseDto(Book book) {
        return BookResponseDto.builder()
                .id(book.getId().toString())
                .title(book.getTitle())
                .author(authorMapper.toAuthorResponseDto(book.getAuthor()))
                .genre(genreMapper.toGenreResponseDto(book.getGenre()))
                .description(book.getDescription())
                .price(book.getPrice())
                .build();
    }

    @Override
    public List<BookResponseDto> toBookResponseDtoList(List<Book> books) {
        return books.stream().map(this::toBookResponseDto).collect(Collectors.toList());
    }

    @Override
    public BookEntity toBookEntity(Book book) {
        return BookEntity.builder()
                .id(book.getId())
                .title(book.getTitle())
                .price(book.getPrice())
                .author(authorMapper.toAuthorEntity(book.getAuthor()))
                .genres(genreMapper.toGenreEntity(book.getGenre()))
                .description(book.getDescription())
                .build();
    }

    @Override
    public List<BookEntity> toBookEntities(List<Book> books) {
        return books.stream().map(this::toBookEntity).collect(Collectors.toList());
    }
}
