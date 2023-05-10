package com.bagandov.shortlinkservice.exception;

import com.bagandov.shortlinkservice.domain.ApiError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(WrongUsageException.class)
    public ResponseEntity<ApiError> linkPairNotFoundExceptionHandler(
            final WrongUsageException ex
    ) {
        return new ResponseEntity<>(new ApiError(ex.getErrorType(), ex.getApiMessage()), HttpStatus.NOT_FOUND);
    }
}
