package org.labs.dto.genre;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class GenreRequestDto {
    @NotBlank(message = "Title is required")
    String title;
}
