package com.zkteco.productapp.repository;

import com.zkteco.productapp.model.dataObject.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {
}
