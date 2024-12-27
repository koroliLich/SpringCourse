package org.labs.service.impl;

import org.labs.exception.BookNotFoundException;
import org.labs.service.BookService;
import org.labs.domain.Book;
import org.labs.dto.BookRequestDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class BookServiceImpl implements BookService {
    List<Book> books = new ArrayList<>();

    @Override
    public Book createBook(BookRequestDto bookRequestDto) {
        Book newBook = Book.builder()
                .id(UUID.randomUUID())
                .title(bookRequestDto.getTitle())
                .description(bookRequestDto.getDescription())
                .author(bookRequestDto.getAuthor())
                .price(bookRequestDto.getPrice())
                .build();

        books.add(newBook);

        return newBook;
    }

    @Override
    public Book updateBook(UUID id, BookRequestDto bookRequestDto) {
        Book existBook = books.stream().filter(b -> b.getId().equals(id)).findFirst()
                .orElseThrow(() -> new BookNotFoundException(id.toString()));

        existBook.setTitle(bookRequestDto.getTitle());
        existBook.setDescription(bookRequestDto.getDescription());
        existBook.setAuthor(bookRequestDto.getAuthor());
        existBook.setPrice(bookRequestDto.getPrice());

        return existBook;
    }

    @Override
    public String deleteBook(UUID id) {
        Book existBook = books.stream().filter(b -> b.getId().equals(id)).findFirst()
                .orElseThrow(() -> new BookNotFoundException(id.toString()));

        books.remove(existBook);

        return String.format("Book with id %s was deleted", id);
    }

    @Override
    public List<Book> getAllBooks(long limit, long offset) {
        return books.stream().skip(offset * limit).limit(limit).toList();
    }

    @Override
    public List<Book> getAllBooksByAuthor(String author, long limit, long offset) {
        return books.stream()
                .filter(book -> book.getAuthor().equals(author))
                .skip(offset * limit).limit(limit).toList();
    }

    @Override
    public Book getBookById(UUID id) {
        return books.stream().filter(b -> b.getId().equals(id)).findFirst()
                .orElseThrow(() -> new BookNotFoundException(id.toString()));
    }
}
