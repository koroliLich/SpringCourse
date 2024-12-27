package org.labs.exception;

public class BookNotFoundException extends RuntimeException {
    private static final String BOOK_NOT_FOUND = "Book with id %s not found";

    public BookNotFoundException(String id) {
        super(String.format(BOOK_NOT_FOUND, id));
    }
}
