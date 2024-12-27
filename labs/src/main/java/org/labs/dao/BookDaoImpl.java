package org.labs.dao;

import lombok.AllArgsConstructor;
import org.labs.domain.Book;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Repository
public class BookDaoImpl implements BookDao {
    private final JdbcTemplate jdbcTemplate;

    @Override
    public Book save(Book book) {
        if (book.getId() == null) {
            String sql = "INSERT INTO books (id, title, author, description, price) VALUES (?, ?, ?, ?, ?)";
            UUID newId = UUID.randomUUID();
            jdbcTemplate.update(sql, newId, book.getTitle(), book.getAuthor(), book.getDescription(), book.getPrice());
            book.setId(newId);
        } else {
            String sql = "UPDATE books SET title = ?, author = ?, description = ?, price = ? WHERE id = ?";
            jdbcTemplate.update(sql, book.getTitle(), book.getAuthor(), book.getDescription(), book.getPrice(), book.getId());
        }
        return book;
    }

    @Override
    public Book findById(UUID id) {
        String sql = "SELECT * FROM books WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new BookMapper(), id);
    }

    @Override
    public List<Book> findAll() {
        String sql = "SELECT * FROM books";
        return jdbcTemplate.query(sql, new BookMapper());
    }

    @Override
    public void delete(UUID id) {
        String sql = "DELETE FROM books WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public List<Book> findByAuthorName(String author) {
        String sql = "SELECT * FROM books WHERE author = ?";
        return jdbcTemplate.query(sql, new BookMapper(), author);
    }
}
