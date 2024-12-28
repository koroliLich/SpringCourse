package org.labs.dto.genre;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GenreResponseDto {
    String id;
    String title;
}
