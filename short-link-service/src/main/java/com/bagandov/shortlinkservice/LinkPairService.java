package com.bagandov.shortlinkservice;

import com.bagandov.shortlinkservice.domain.LinkPair;
import com.bagandov.shortlinkservice.domain.LinkPairRepository;
import com.bagandov.shortlinkservice.exception.LinkPairNotFoundException;
import com.bagandov.shortlinkservice.validators.LongLinkValidator;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;

@Component
public class LinkPairService {

    @Autowired
    private LinkPairRepository repository;

    @Autowired
    private LongLinkValidator validator;

    public List<LinkPair> findAll() {
        return repository.findAll();
    }

    public LinkPair create(String longLing) {
        validator.validate(longLing);
        return repository.save(new LinkPair(RandomStringUtils.random(8, true, true), longLing));
    }

    public LinkPair findOne(String shortLink) {
        Optional<LinkPair> linkPairOptional = repository.findById(shortLink);
        if (linkPairOptional.isPresent()) {
            return linkPairOptional.get();
        } else {
            throw new LinkPairNotFoundException(shortLink);
        }
    }
}
