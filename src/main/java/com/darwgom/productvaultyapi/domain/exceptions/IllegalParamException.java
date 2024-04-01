package com.darwgom.productvaultyapi.domain.exceptions;

public class IllegalParamException extends RuntimeException {
    public IllegalParamException(String message) {
        super(message);
    }
}
