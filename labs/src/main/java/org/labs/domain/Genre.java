package org.labs.domain;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class Genre {
    UUID id;
    String title;
}
