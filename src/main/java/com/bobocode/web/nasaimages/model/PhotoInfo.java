package com.bobocode.web.nasaimages.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PhotoInfo {
    @JsonProperty("img_src")
    private String uri;

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }
}
