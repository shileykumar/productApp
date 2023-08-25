package com.zkteco.productapp.enums;

public enum SuccessResponseCode {
    SUCCESS("PROD0000"),
    CREATED("PROD0001"),
    FETCHED("PROD0002"),
    DELETED("PROD0003"),
    UPDATED("PROD0004")
    ;

    private String value;
    SuccessResponseCode(String vale) {
        this.value = vale;
    }

    public String getValue() {
        return value;
    }
}
