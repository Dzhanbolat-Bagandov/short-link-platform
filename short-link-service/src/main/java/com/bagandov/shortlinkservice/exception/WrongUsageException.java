package com.bagandov.shortlinkservice.exception;

import com.bagandov.shortlinkservice.domain.ApiError;

//type of exception that isn't supposed to be handled internally and is
// implied to produce response
public class WrongUsageException extends RuntimeException {

    //this couples WrongUsageException with ApiError which I'm not sure is correct
    private final ApiError.ErrorType errorType;

    private final String apiMessage;

    public WrongUsageException(ApiError.ErrorType errorType, String apiMessage) {
        this.errorType = errorType;
        this.apiMessage = apiMessage;
    }

    public ApiError.ErrorType getErrorType() {
        return errorType;
    }

    public String getApiMessage() {
        return apiMessage;
    }
}
