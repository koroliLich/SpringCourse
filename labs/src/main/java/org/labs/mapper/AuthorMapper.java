package org.labs.mapper;

import org.labs.domain.Author;
import org.labs.dto.author.AuthorResponseDto;
import org.labs.repository.entity.AuthorEntity;

import java.util.List;

public interface AuthorMapper {
    Author toAuthor(AuthorEntity authorEntity);
    List<Author> toAuthors(Iterable<AuthorEntity> authorEntities);
    AuthorResponseDto toAuthorResponseDto(Author author);
    List<AuthorResponseDto> toAuthorResponseDtos(List<Author> authors);
    AuthorEntity toAuthorEntity(Author author);
}
