package com.zkteco.productapp.service.impl;

import com.zkteco.productapp.enums.ErrorResponseCode;
import com.zkteco.productapp.enums.SuccessResponseCode;
import com.zkteco.productapp.model.dataObject.Product;
import com.zkteco.productapp.model.dto.CustomPageable;
import com.zkteco.productapp.model.dto.PageableResponseDTO;
import com.zkteco.productapp.model.dto.Result;
import com.zkteco.productapp.repository.ProductRepository;
import com.zkteco.productapp.service.ProductService;
import com.zkteco.productapp.utils.BasicUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl extends BasicUtils implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public Result createProduct(Product payload) {
        return prepareResponseObject(SuccessResponseCode.CREATED.getValue(),
                productRepository.insert(payload));
    }

    @Override
    public Result getAllProducts() {
        Collection<Product> products = productRepository.findAll();
        if (isNullOrEmpty(products)) {
            return prepareResponseObject(ErrorResponseCode.NOT_FOUND.getValue(),null);
        }
        return prepareResponseObject(ErrorResponseCode.NOT_FOUND.getValue(), products);
    }

    @Override
    public Result filterProduct(CustomPageable pageable) {
        Pageable paging = PageRequest.of(pageable.getPageNumber(),
                pageable.getPageSize(), Sort.by(pageable.getSortBy()));
        Page<Product> products = productRepository.findAll(paging);

        PageableResponseDTO response = new PageableResponseDTO();
        if (isNullOrEmpty(response)) {
            return prepareResponseObject(ErrorResponseCode.NOT_FOUND.getValue(), null);
        }
        response.setCurrentPage(products.getNumber());
        response.setObject(products.getContent());
        response.setPageSize(products.getSize());
        response.setTotalCount(products.getTotalElements());
        response.setTotalPages(products.getTotalPages());

        return prepareResponseObject(SuccessResponseCode.FETCHED.getValue(), response);
    }

    @Override
    public Result findById(String id) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isEmpty()) {
            return  prepareResponseObject(ErrorResponseCode.NOT_FOUND.getValue(),null);
        }
        return  prepareResponseObject(SuccessResponseCode.FETCHED.getValue(), product.get());
    }

    @Override
    public Result updateProduct(Product payload) {
        Optional<Product> optionalProduct = productRepository.findById(payload.getId());
        if (optionalProduct.isEmpty()) {
            return  prepareResponseObject(ErrorResponseCode.NOT_FOUND.getValue(),null);
        }
        return  prepareResponseObject(SuccessResponseCode.UPDATED.getValue(), productRepository.save(payload));
    }

    @Override
    public Result deleteProduct(String id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isEmpty()) {
            return  prepareResponseObject(ErrorResponseCode.NOT_FOUND.getValue(),null);
        }
        productRepository.deleteById(id);
         return  prepareResponseObject(SuccessResponseCode.DELETED.getValue(), null);
    }
}
