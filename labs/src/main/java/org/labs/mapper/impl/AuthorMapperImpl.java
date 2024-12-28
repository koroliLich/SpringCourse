package org.labs.mapper.impl;

import lombok.AllArgsConstructor;
import org.labs.domain.Author;
import org.labs.dto.author.AuthorResponseDto;
import org.labs.mapper.AuthorMapper;
import org.labs.repository.entity.AuthorEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class AuthorMapperImpl implements AuthorMapper {
    @Override
    public Author toAuthor(AuthorEntity authorEntity) {
        return Author.builder()
                .id(authorEntity.getId())
                .name(authorEntity.getName())
                .build();
    }

    @Override
    public List<Author> toAuthors(Iterable<AuthorEntity> authorEntities) {
        return ((List<AuthorEntity>) authorEntities).stream()
                .map(this::toAuthor)
                .collect(Collectors.toList());
    }

    @Override
    public AuthorResponseDto toAuthorResponseDto(Author author) {
        return AuthorResponseDto.builder()
                .id(author.getId().toString())
                .name(author.getName())
                .build();
    }

    @Override
    public List<AuthorResponseDto> toAuthorResponseDtos(List<Author> authors) {
        return authors.stream().map(this::toAuthorResponseDto).collect(Collectors.toList());
    }

    @Override
    public AuthorEntity toAuthorEntity(Author author) {
        return AuthorEntity.builder()
                .id(author.getId())
                .name(author.getName())
                .build();
    }
}
