package com.darwgom.productvaultyapi.domain.exceptions;

public class CustomInvalidTokenException extends InvalidTokenException {
    public CustomInvalidTokenException(String message) {
        super(message);
    }
}
