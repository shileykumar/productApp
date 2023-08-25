package com.zkteco.productapp.model.dto;

import lombok.Data;

@Data
public class PageableResponseDTO {
    private Object object;
    private Integer currentPage;
    private Integer pageSize;
    private Long totalCount;
    private Integer totalPages;
}
