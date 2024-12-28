package org.labs.repository;

import org.labs.repository.entity.AuthorEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AuthorRepository extends CrudRepository<AuthorEntity, UUID> {

}
