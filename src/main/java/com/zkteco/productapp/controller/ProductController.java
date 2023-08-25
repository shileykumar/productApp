package com.zkteco.productapp.controller;

import com.zkteco.productapp.model.dataObject.Product;
import com.zkteco.productapp.model.dto.CustomPageable;
import com.zkteco.productapp.model.dto.Result;
import com.zkteco.productapp.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/web")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping("/product")
    public Result createProduct(@RequestBody Product payload) {
        return productService.createProduct(payload);
    }

    @GetMapping("/products/list")
    public Result fetchAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/products")
    public Result filterProduct(CustomPageable pageable) {
        return productService.filterProduct(pageable);
    }

    @GetMapping("/product/{id}")
    public Result fetchById(@PathVariable String id) {
        return productService.findById(id);
    }

    @PutMapping("/product")
    public Result updateProduct(@RequestBody Product payload) {
        return productService.updateProduct(payload);
    }

    @DeleteMapping("/product/{id}")
    public Result deleteProduct(@PathVariable String id) {
        return productService.deleteProduct(id);
    }
}
