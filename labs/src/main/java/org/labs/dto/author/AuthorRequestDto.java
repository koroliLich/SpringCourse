package org.labs.dto.author;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AuthorRequestDto {
    @NotBlank(message = "Name is required")
    String name;
}
