package com.zkteco.productapp.model.dto;

import lombok.Data;

@Data
public class Result {
    private String code;
    private String message;
    private Object data;
}
