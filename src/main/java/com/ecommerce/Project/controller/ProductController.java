package com.ecommerce.Project.controller;

import com.ecommerce.Project.model.Product;
import com.ecommerce.Project.payload.ProductDTO;
import com.ecommerce.Project.payload.ProductResponse;
import com.ecommerce.Project.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping("/admin/category/{categoryId}/product")
    public ResponseEntity<ProductDTO>addProduct(@RequestBody Product product,
                                                @PathVariable Long categoryId){
       ProductDTO productDTO = productService.addProduct(categoryId,product);
       return new ResponseEntity<>(productDTO, HttpStatus.CREATED);
    }

    @GetMapping("/public/products")
    public ResponseEntity<ProductResponse>getAllProducts(){
        ProductResponse productResponse = productService.getAllProducts();
        return new ResponseEntity<>(productResponse,HttpStatus.OK);
    }

    @GetMapping("/public/category/{categoryId}/products")
    public ResponseEntity<ProductResponse>getProductByCategoryId(@PathVariable Long categoryId){
        ProductResponse productResponse=productService.getProductById(categoryId);
        return new ResponseEntity<>(productResponse,HttpStatus.OK);
    }
}
