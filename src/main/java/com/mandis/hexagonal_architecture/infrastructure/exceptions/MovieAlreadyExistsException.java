package com.mandis.hexagonal_architecture.infrastructure.exceptions;

public class MovieAlreadyExistsException extends RuntimeException {

    public MovieAlreadyExistsException(String message) {
        super(message);
    }

}
