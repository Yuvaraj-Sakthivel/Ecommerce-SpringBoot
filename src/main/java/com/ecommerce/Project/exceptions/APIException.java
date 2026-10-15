package com.ecommerce.Project.exceptions;

public class APIException extends RuntimeException{
    private static final Long serialVersionId = 1L;

    public APIException() {
    }

    public APIException(String message) {
        super(message);
    }
}
