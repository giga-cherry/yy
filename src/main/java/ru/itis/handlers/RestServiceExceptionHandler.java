package ru.itis.handlers;

import org.hibernate.service.spi.ServiceException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.itis.api.dto.response.ExceptionDto;


import java.time.Instant;

@RestControllerAdvice
public class RestServiceExceptionHandler {

    @ExceptionHandler(ServiceException.class)
    public ResponseEntity<ExceptionDto> handleServiceException(ServiceException ex, HttpServletRequest request) {
        return ResponseEntity
                .status(ex.getErrorStatus())
                .body(ExceptionDto.builder()
                        .errorCode(ex.getErrorStatus())
                        .errorMessage(ex.getErrorMessage())
                        .errorTimestamp(Instant.now().toString())
                        .errorUrl(request.getRequestURI())
                        .build()
                );
    }
}
