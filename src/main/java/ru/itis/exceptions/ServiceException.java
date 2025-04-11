package ru.itis.exceptions;


import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public abstract class ServiceException extends RuntimeException {
    private final int errorStatus;
    private final String errorMessage;

    public int getErrorStatus() {
        return errorStatus;
    }
}