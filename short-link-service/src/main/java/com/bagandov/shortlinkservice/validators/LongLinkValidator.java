package com.bagandov.shortlinkservice.validators;

import com.bagandov.shortlinkservice.exception.LinkPairValidationException;
import org.springframework.stereotype.Component;

@Component
public class LongLinkValidator {

    private static final String VALID_LINK_REGEX =
            "^(http(s)://.)[-a-zA-Z0-9@:%._+~#=]{2,256}\\.[a-z]{2,6}\\b([-a-zA-Z0-9@:%_+.~#?&/=]*)$";

    public void validate(String longLink) {
        if (longLink == null || !(longLink.startsWith("http://") || longLink.startsWith("https://"))) {
            throw LinkPairValidationException.protocolMissing(longLink);
        }
        if (!longLink.matches(VALID_LINK_REGEX)) {
            throw LinkPairValidationException.wrongFormat(longLink);
        }
    }
}
