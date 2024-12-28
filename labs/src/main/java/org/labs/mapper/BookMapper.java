package org.labs.mapper;

import org.labs.domain.Book;
import org.labs.dto.book.BookResponseDto;
import org.labs.repository.entity.BookEntity;

import java.util.List;

public interface BookMapper {
    Book toBook(BookEntity bookEntity);

    List<Book> toBooks(List<BookEntity> bookEntities);

    BookResponseDto toBookResponseDto(Book book);

    List<BookResponseDto> toBookResponseDtoList(List<Book> books);

    BookEntity toBookEntity(Book book);

    List<BookEntity> toBookEntities(List<Book> books);
}
