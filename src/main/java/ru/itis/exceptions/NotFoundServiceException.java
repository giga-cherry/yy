package ru.itis.exceptions;

import lombok.Getter;

public abstract class NotFoundServiceException extends ServiceException {
    public NotFoundServiceException(String errorMessage) {
        super(404, errorMessage);
    }
}
