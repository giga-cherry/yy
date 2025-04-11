package ru.itis.exceptions;

import lombok.Getter;

public abstract class InternalErrorServiceException extends ServiceException{
    public InternalErrorServiceException(String errorMessage) {
        super(500, errorMessage);
    }
}
