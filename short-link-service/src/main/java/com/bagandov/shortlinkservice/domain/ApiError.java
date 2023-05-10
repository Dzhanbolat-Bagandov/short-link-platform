package com.bagandov.shortlinkservice.domain;

public class ApiError {

    private ErrorType errorType;
    private String message;

    public ApiError(ErrorType errorType) {
        this.errorType = errorType;
    }

    public ApiError(ErrorType errorType, String message) {
        this.errorType = errorType;
        this.message = message;
    }

    public ErrorType getErrorType() {
        return errorType;
    }

    public String getMessage() {
        return message;
    }

    public enum ErrorType {
        LINK_PAIR_NOT_FOUND,
        PROTOCOL_MISSING_IN_LINK,
        WRONG_LINK_FORMAT
    }


}
