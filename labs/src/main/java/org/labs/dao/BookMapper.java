package org.labs.dao;

import org.labs.domain.Book;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class BookMapper implements RowMapper<Book> {
    public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
        return Book.builder()
                .id(UUID.fromString(rs.getString("id")))
                .title(rs.getString("title"))
                .author(rs.getString("author"))
                .description(rs.getString("description"))
                .price(rs.getDouble("price"))
                .build();
    }
}
