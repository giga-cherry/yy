package ru.itis.exceptions;

public class EmailNotFoundServiceException extends NotFoundServiceException {
    public EmailNotFoundServiceException() {
        super("Email not found");
    }
}
