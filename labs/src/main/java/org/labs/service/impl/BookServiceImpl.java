package org.labs.service.impl;

import lombok.AllArgsConstructor;
import org.labs.dao.BookDao;
import org.labs.domain.Book;
import org.labs.dto.BookRequestDto;
import org.labs.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookDao bookDao;

    @Override
    public Book createBook(BookRequestDto bookRequestDto) {
        Book newBook = Book.builder()
                .title(bookRequestDto.getTitle())
                .description(bookRequestDto.getDescription())
                .author(bookRequestDto.getAuthor())
                .price(bookRequestDto.getPrice())
                .build();

        try {
            return bookDao.save(newBook);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public Book updateBook(UUID id, BookRequestDto bookRequestDto) {
        Book existBook = bookDao.findById(id);

        existBook.setTitle(bookRequestDto.getTitle());
        existBook.setDescription(bookRequestDto.getDescription());
        existBook.setAuthor(bookRequestDto.getAuthor());
        existBook.setPrice(bookRequestDto.getPrice());

        try {
            return bookDao.save(existBook);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public String deleteBook(UUID id) {
        bookDao.delete(id);

        try {
            return String.format("Book with id %s was deleted", id);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<Book> getAllBooks() {
        return bookDao.findAll();
    }

    @Override
    public List<Book> getAllBooksByAuthor(String author) {
        return bookDao.findByAuthorName(author);
    }

    @Override
    public Book getBookById(UUID id) {
        return bookDao.findById(id);
    }
}
