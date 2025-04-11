package ru.itis.exceptions;

import lombok.Getter;

public abstract class BadRequestServiceException extends ServiceException{
    public BadRequestServiceException(String errorMessage) {
        super(400, errorMessage);
    }
}
