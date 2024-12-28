package org.labs.repository.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name = "authors")
public class AuthorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID id;

    String name;
}
