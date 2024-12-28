package org.labs.service;

import org.labs.domain.Author;
import org.labs.dto.author.AuthorRequestDto;

import java.util.List;
import java.util.UUID;

public interface AuthorService {
    Author createAuthor(AuthorRequestDto authorRequestDto);
    Author updateAuthor(UUID id, AuthorRequestDto authorRequestDto);
    Author getAuthorById(UUID id);
    List<Author> getAuthors();
    void deleteAuthor(UUID id);
}
