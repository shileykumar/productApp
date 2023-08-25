package com.zkteco.productapp.enums;

public enum ErrorResponseCode {
    NOT_FOUND("PROE0000"),
    ;

    private String value;

    ErrorResponseCode(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
