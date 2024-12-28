package org.labs.repository.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "books")
public class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID id;

    String title;

    String description;

    @ManyToOne
    @JoinColumn(name = "author_id", referencedColumnName = "id")
    GenreEntity genres;

    @ManyToOne
    @JoinColumn(name = "book_id", referencedColumnName = "id")
    AuthorEntity author;

    Double price;
}
