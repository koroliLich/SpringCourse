package org.labs.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class BookRequestDto {
    @NotBlank(message = "Title is required")
    String title;

    @NotBlank(message = "Author is required")
    String author;

    @NotBlank(message = "Description is required")
    String description;

    @NotNull(message = "Price cannot be null")
    Double price;
}
