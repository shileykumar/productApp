package com.zkteco.productapp.model.dto;

import lombok.Data;

@Data
public class CustomPageable {

    private Integer pageNumber;
    private Integer pageSize;
    private String sortBy;
}
