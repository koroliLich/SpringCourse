package org.labs.dao;

import org.labs.domain.Book;

import java.util.List;
import java.util.UUID;

public interface BookDao {
    Book save(Book book);
    Book findById(UUID id);
    List<Book> findAll();
    void delete(UUID id);
    List<Book> findByAuthorName(String author);
}
