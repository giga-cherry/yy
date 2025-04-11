package ru.itis.exceptions;

public class EmptyRequestServiceException extends BadRequestServiceException {
    public EmptyRequestServiceException( ) {
        super("Empty request parameter/parameters");
    }
}
