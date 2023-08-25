package com.zkteco.productapp.model.dataObject;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "product")
@Data
public class Product {

    @Id
    private String id;
    private String name;
    private Long price;
}
