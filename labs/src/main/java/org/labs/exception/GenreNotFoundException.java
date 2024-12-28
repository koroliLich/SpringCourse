package org.labs.exception;

public class GenreNotFoundException extends RuntimeException {
    private static final String GENRE_NOTFOUND = "Genre with id: %s not found";
    public GenreNotFoundException(String id) {
        super(String.format(GENRE_NOTFOUND, id));
    }
}
