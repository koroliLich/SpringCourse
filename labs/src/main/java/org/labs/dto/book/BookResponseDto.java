package org.labs.dto.book;

import lombok.Builder;
import lombok.Data;
import org.labs.dto.author.AuthorResponseDto;
import org.labs.dto.genre.GenreResponseDto;

@Data
@Builder
public class BookResponseDto {
    String id;
    String title;
    AuthorResponseDto author;
    GenreResponseDto genre;
    String description;
    double price;
}
