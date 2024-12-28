package org.labs.service.impl;

import lombok.AllArgsConstructor;
import org.labs.domain.Author;
import org.labs.domain.Book;
import org.labs.domain.Genre;
import org.labs.dto.book.BookRequestDto;
import org.labs.exception.BookNotFoundException;
import org.labs.mapper.AuthorMapper;
import org.labs.mapper.BookMapper;
import org.labs.mapper.GenreMapper;
import org.labs.repository.BookRepository;
import org.labs.repository.entity.BookEntity;
import org.labs.service.AuthorService;
import org.labs.service.BookService;
import org.labs.service.GenreService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final GenreService genreService;
    private final AuthorService authorService;
    private final BookMapper bookMapper;
    private final AuthorMapper authorMapper;
    private final GenreMapper genreMapper;

    @Override
    @Transactional
    public Book createBook(BookRequestDto bookRequestDto) {
        Author author = authorService.getAuthorById(bookRequestDto.getAuthorId());
        Genre genre = genreService.getGenreById(bookRequestDto.getGenreId());

        BookEntity newBook = BookEntity.builder()
                .title(bookRequestDto.getTitle())
                .description(bookRequestDto.getDescription())
                .price(bookRequestDto.getPrice())
                .genres(genreMapper.toGenreEntity(genre))
                .author(authorMapper.toAuthorEntity(author))
                .build();

        try {
            return bookMapper.toBook(bookRepository.save(newBook));
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Book updateBook(UUID id, BookRequestDto bookRequestDto) {
        Book existBook = getBookById(id);
        Author author = authorService.getAuthorById(bookRequestDto.getAuthorId());
        Genre genre = genreService.getGenreById(bookRequestDto.getGenreId());

        existBook.setTitle(bookRequestDto.getTitle());
        existBook.setDescription(bookRequestDto.getDescription());
        existBook.setPrice(bookRequestDto.getPrice());
        existBook.setAuthor(author);
        existBook.setGenre(genre);

        try {
            return bookMapper.toBook(bookMapper.toBookEntity(existBook));
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    @Transactional
    public String deleteBook(UUID id) {
        try {
            bookRepository.deleteById(id);
            return String.format("Book with id %s was deleted", id);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<Book> getAllBooks() {
        return bookMapper.toBooks(bookRepository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public List<Book> getAllBooksByAuthor(UUID authorId) {
        return bookMapper.toBooks(bookRepository.findByAuthor_Id(authorId));
    }

    @Override
    @Transactional(readOnly = true)
    public List<Book> getAllBooksByGenre(UUID genreId) {
        return bookMapper.toBooks(bookRepository.findByGenre_Id(genreId));
    }

    @Override
    @Transactional(readOnly = true)
    public Book getBookById(UUID id) {
        return bookMapper.toBook(bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException(id.toString())));
    }
}
