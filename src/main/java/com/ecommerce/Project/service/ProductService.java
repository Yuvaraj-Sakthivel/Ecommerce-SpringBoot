package com.ecommerce.Project.service;

import com.ecommerce.Project.payload.ProductDTO;
import com.ecommerce.Project.payload.ProductResponse;
import org.springframework.web.multipart.MultipartFile;

public interface ProductService {
    ProductDTO addProduct(Long categoryId, ProductDTO product);

    ProductResponse getAllProducts();

    ProductResponse getProductById(Long categoryId);

    ProductResponse getProductByKeyword(String keyword);

    ProductDTO updateProductById(Long productId, ProductDTO productDTO);

    ProductDTO deleteProduct(Long productId);

    ProductDTO updateImageById(Long productId, MultipartFile image);
}
