package ru.itis.exceptions;

public class UserNotFoundServiceException extends NotFoundServiceException {
    public UserNotFoundServiceException() {
        super("User not found");
    }
}
