package com.mandis.hexagonal_architecture.infrastructure.exceptions;

public class MovieNotFoundException extends RuntimeException {
    public MovieNotFoundException(String s) {
        super(s);
    }
}
