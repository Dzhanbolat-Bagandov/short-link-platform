package com.bagandov.shortlinkservice.exception;

import com.bagandov.shortlinkservice.domain.ApiError;

public class LinkPairValidationException extends WrongUsageException {

    private final String providedLongLink;

    private LinkPairValidationException(
            ApiError.ErrorType errorType,
            String providedLongLink,
            String apiMessage
    ) {
        super(errorType, apiMessage);
        this.providedLongLink = providedLongLink;
    }

    public static LinkPairValidationException protocolMissing(String providedLongLink) {
        return new LinkPairValidationException(
                ApiError.ErrorType.PROTOCOL_MISSING_IN_LINK,
                providedLongLink,
                "Link should start with \"http://\" or \"https://\"."
        );
    }

    public static LinkPairValidationException wrongFormat(String providedLongLink) {
        return new LinkPairValidationException(
                ApiError.ErrorType.WRONG_LINK_FORMAT,
                providedLongLink,
                String.format("Provided link \"%s\" is not of correct format.", providedLongLink)
        );
    }

    public String getProvidedLongLink() {
        return providedLongLink;
    }

}
