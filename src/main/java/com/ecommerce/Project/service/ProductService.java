package com.ecommerce.Project.service;

import com.ecommerce.Project.model.Product;
import com.ecommerce.Project.payload.ProductDTO;
import com.ecommerce.Project.payload.ProductResponse;

public interface ProductService {
    ProductDTO addProduct(Long categoryId, Product product);

    ProductResponse getAllProducts();

    ProductResponse getProductById(Long categoryId);

    ProductResponse getProductByKeyword(String keyword);

    ProductDTO updateProductbyId(Long productId, Product product);
}
