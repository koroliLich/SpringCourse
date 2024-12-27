package org.labs.domain;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class Book {
    UUID id;
    String title;
    String author;
    String description;
    double price;
}
