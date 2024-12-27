package org.labs.mapper.impl;

import org.labs.domain.Book;
import org.labs.dto.BookResponseDto;
import org.labs.mapper.BookMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BookMapperImpl implements BookMapper {

    @Override
    public BookResponseDto toBookResponseDto(Book book) {
        return BookResponseDto.builder()
                .id(book.getId().toString())
                .title(book.getTitle())
                .author(book.getAuthor())
                .description(book.getDescription())
                .price(book.getPrice())
                .build();
    }

    @Override
    public List<BookResponseDto> toBookResponseDtoList(List<Book> books) {
        return books.stream().map(this::toBookResponseDto).collect(Collectors.toList());
    }
}
