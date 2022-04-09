package com.testinium.sgms.exception;

import lombok.Getter;

@Getter
public class NotFoundException extends RuntimeException {
    private final String i18nId;
    private final String debugId;

    public NotFoundException(String message, String i18nId, String debugId) {
        super(message);
        this.i18nId = i18nId;
        this.debugId = debugId;
    }
}
