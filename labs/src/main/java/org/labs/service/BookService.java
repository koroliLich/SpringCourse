package org.labs.service;

import org.labs.domain.Book;
import org.labs.dto.BookRequestDto;

import java.util.List;
import java.util.UUID;

public interface BookService {
    Book createBook(BookRequestDto bookRequestDto);

    Book updateBook(UUID id, BookRequestDto bookRequestDto);

    String deleteBook(UUID id);

    List<Book> getAllBooks();

    List<Book> getAllBooksByAuthor(String author);

    Book getBookById(UUID id);
}
