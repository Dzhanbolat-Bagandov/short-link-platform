package com.bagandov.redirectservice.models;

public class LongLinkModel {

    private String longLink;

    public LongLinkModel() {
    }

    public LongLinkModel(String longLink) {
        this.longLink = longLink;
    }

    public String getLongLink() {
        return longLink;
    }

    public void setLongLink(String longLink) {
        this.longLink = longLink;
    }
}
