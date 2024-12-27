package org.labs.mapper;

import org.labs.domain.Book;
import org.labs.dto.BookResponseDto;

import java.util.List;

public interface BookMapper {
    BookResponseDto toBookResponseDto(Book book);

    List<BookResponseDto> toBookResponseDtoList(List<Book> books);
}
