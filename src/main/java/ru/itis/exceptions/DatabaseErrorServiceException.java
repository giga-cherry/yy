package ru.itis.exceptions;

public class DatabaseErrorServiceException extends InternalErrorServiceException {
    public DatabaseErrorServiceException() {
        super("Database error");
    }
}
