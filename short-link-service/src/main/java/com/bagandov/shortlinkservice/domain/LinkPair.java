package com.bagandov.shortlinkservice.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "link_pair")
public class LinkPair {

    @Id
    @Column(name = "short_link")
    private String shortLink;

    @Column(name = "long_link")
    private String longLink;

    public String getShortLink() {
        return shortLink;
    }

    public void setShortLink(String shortLink) {
        this.shortLink = shortLink;
    }

    public String getLongLink() {
        return longLink;
    }

    public void setLongLink(String longLink) {
        this.longLink = longLink;
    }

    public LinkPair() {
    }

    public LinkPair(String shortLink, String longLink) {
        this.shortLink = shortLink;
        this.longLink = longLink;
    }
}
