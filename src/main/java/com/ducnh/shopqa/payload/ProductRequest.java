package com.ducnh.shopqa.payload;

import lombok.Data;

@Data
public class ProductRequest {
    private String name;
    private Double price;
    private Double discount;
    private String category;
    private String type;
    private String material;
    private String image;
    private String size;  
}
