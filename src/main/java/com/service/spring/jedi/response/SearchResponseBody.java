package com.service.spring.jedi.response;

import lombok.Getter;


public class SearchResponseBody<T> {

    private final int count;

    @Getter
    private final T results;

    public SearchResponseBody(int count, T results) {
        this.count = count;
        this.results = results;
    }
}