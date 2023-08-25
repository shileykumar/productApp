package com.zkteco.productapp.service;

import com.zkteco.productapp.model.dataObject.Product;
import com.zkteco.productapp.model.dto.CustomPageable;
import com.zkteco.productapp.model.dto.Result;
import org.springframework.data.domain.Page;

import java.util.Collection;

public interface ProductService {
    Result createProduct(Product payload);
    Result getAllProducts();
    Result filterProduct(CustomPageable pageable);
    Result findById(String id);
    Result updateProduct(Product payload);
    Result deleteProduct(String id);
}
