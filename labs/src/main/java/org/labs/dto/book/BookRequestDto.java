package org.labs.dto.book;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.UUID;

@Data
public class BookRequestDto {
    @NotBlank(message = "Title is required")
    String title;

    @NotBlank(message = "Description is required")
    String description;

    @NotNull(message = "Price cannot be null")
    Double price;

    UUID authorId;

    UUID genreId;
}
