package com.bagandov.redirectservice.service;

import com.bagandov.redirectservice.models.LinkPair;
import com.bagandov.redirectservice.models.LongLinkModel;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ExternalRequestSender {

    private final RestTemplate restTemplate;

    public ExternalRequestSender(
            @Qualifier("slsRestTemplate") RestTemplate restTemplate
    ) {
        this.restTemplate = restTemplate;
    }

    public LinkPair getLinkPair(String shortLink) {
        System.out.println("Sent request");
        LinkPair response =
                restTemplate.getForObject("/main/" + shortLink, LinkPair.class);
        return response;
    }

    public LinkPair createLinkPair(String longLink) {
        LinkPair response =
                restTemplate.postForObject("/main/create", new LongLinkModel(longLink), LinkPair.class);
        return response;
    }
}
