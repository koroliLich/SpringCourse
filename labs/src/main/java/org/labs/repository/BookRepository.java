package org.labs.repository;

import org.labs.repository.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, UUID> {
    List<BookEntity> findByAuthor_Id(UUID authorId);

    @Query("SELECT b FROM BookEntity b WHERE b.genres.id = :genreId")
    List<BookEntity> findByGenre_Id(UUID genreId);
}
