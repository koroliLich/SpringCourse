package org.labs.repository;

import org.labs.repository.entity.GenreEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface GenreRepository extends CrudRepository<GenreEntity, UUID> {
}
