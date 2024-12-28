package org.labs.dto.author;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AuthorResponseDto {
    String id;
    String name;
}
