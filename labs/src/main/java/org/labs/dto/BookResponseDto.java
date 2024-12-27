package org.labs.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BookResponseDto {
    String id;
    String title;
    String author;
    String description;
    double price;
}
