package com.bagandov.shortlinkservice.exception;

import com.bagandov.shortlinkservice.domain.ApiError;

public class LinkPairNotFoundException extends WrongUsageException {

    private final String shortLink;

    public LinkPairNotFoundException(String shortLink) {
        super(
                ApiError.ErrorType.LINK_PAIR_NOT_FOUND,
                String.format("There is no link associated with %s identifier", shortLink)
        );
        this.shortLink = shortLink;
    }

    public String getShortLink() {
        return shortLink;
    }
}
