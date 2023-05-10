package com.bagandov.redirectservice.service;

import com.bagandov.redirectservice.exception.ErrorType;
import com.bagandov.redirectservice.exception.InterruptingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResponseErrorHandler;
import java.io.IOException;

@Component
public class ShortLinkServiceErrorHandler implements ResponseErrorHandler {

    private static final String ERROR_NODE = "errorType";

    @Override
    public boolean hasError(ClientHttpResponse response) throws IOException {
        return !response.getStatusCode().is2xxSuccessful();
    }

    @Override
    public void handleError(ClientHttpResponse response) throws IOException {
        JsonNode node = new ObjectMapper().readTree(response.getBody());
        String error = null;
        if (node.hasNonNull(ERROR_NODE)) {
            error = node.get(ERROR_NODE).asText();
        }
        switch (ErrorType.valueOf(error)) {
            case LINK_PAIR_NOT_FOUND -> throw new InterruptingException("No link matching the supplied identifier");
            case PROTOCOL_MISSING_IN_LINK -> throw new InterruptingException("Link should start with \"http://\" or \"https://\"");
            case WRONG_LINK_FORMAT -> throw new InterruptingException("Link has wrong format");
        }
    }
}
