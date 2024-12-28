package org.labs.service.impl;

import lombok.AllArgsConstructor;
import org.labs.domain.Author;
import org.labs.dto.author.AuthorRequestDto;
import org.labs.exception.AuthorNotFoundException;
import org.labs.mapper.AuthorMapper;
import org.labs.repository.AuthorRepository;
import org.labs.repository.entity.AuthorEntity;
import org.labs.service.AuthorService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class AuthorServiceImpl implements AuthorService {
    private final AuthorMapper authorMapper;
    private final AuthorRepository authorRepository;

    @Override
    @Transactional
    public Author createAuthor(AuthorRequestDto authorRequestDto) {
        AuthorEntity authorEntity = AuthorEntity.builder()
                .name(authorRequestDto.getName())
                .build();
        try {
            return authorMapper.toAuthor(authorRepository.save(authorEntity));
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Author updateAuthor(UUID id, AuthorRequestDto authorRequestDto) {
        Author existAuthor = getAuthorById(id);

        existAuthor.setName(authorRequestDto.getName());

        try {
            return authorMapper.toAuthor(authorRepository.save(authorMapper.toAuthorEntity(existAuthor)));
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    @Transactional(readOnly = true)
    public Author getAuthorById(UUID id) {
        return authorMapper.toAuthor(authorRepository.findById(id).orElseThrow(() -> new AuthorNotFoundException(id.toString())));
    }

    @Override
    @Transactional(readOnly = true)
    public List<Author> getAuthors() {
        return authorMapper.toAuthors(authorRepository.findAll());
    }

    @Override
    @Transactional
    public void deleteAuthor(UUID id) {
        try {
            authorRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
