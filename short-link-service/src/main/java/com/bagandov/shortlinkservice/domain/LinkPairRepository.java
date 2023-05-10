package com.bagandov.shortlinkservice.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.ListCrudRepository;

public interface LinkPairRepository extends ListCrudRepository<LinkPair, String> {
}
