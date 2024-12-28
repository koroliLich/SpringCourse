package org.labs.exception;

public class AuthorNotFoundException extends RuntimeException {
    private static final String AUTHOR_NOT_FOUND = "Author with id: %s not found";
    public AuthorNotFoundException(String id) {
        super(String.format(AUTHOR_NOT_FOUND, id));
    }
}
