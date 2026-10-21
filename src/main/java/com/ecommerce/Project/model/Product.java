package com.ecommerce.Project.model;

import jakarta.persistence.Entity;

@Entity
public class Product {
    private Long productId;
    private String productName;
    private String description;
    private Integer quantity;
    private double price;
    private double specialPrice;

    private Category category;
}
