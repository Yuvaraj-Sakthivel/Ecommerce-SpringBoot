package com.ecommerce.Project.controller;

import com.ecommerce.Project.model.Product;
import com.ecommerce.Project.payload.ProductDTO;
import com.ecommerce.Project.payload.ProductResponse;
import com.ecommerce.Project.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping("/admin/category/{categoryId}/product")
    public ResponseEntity<ProductDTO>addProduct(@RequestBody ProductDTO productDTO,
                                                @PathVariable Long categoryId){
       ProductDTO newProductDTO = productService.addProduct(categoryId,productDTO);
       return new ResponseEntity<>(newProductDTO, HttpStatus.CREATED);
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

    @GetMapping("/public/product/keyword/{keyword}")
    public ResponseEntity<ProductResponse>getProductByKeyword(@PathVariable String keyword){
        ProductResponse productResponse = productService.getProductByKeyword(keyword);
        return new ResponseEntity<>(productResponse,HttpStatus.OK);
    }

    @PutMapping("/admin/products/{productId}")
    public ResponseEntity<ProductDTO>updateProduct(@RequestBody ProductDTO productDTO,
                                                    @PathVariable Long productId){
        ProductDTO updatedProductDTO=productService.updateProductById(productId, productDTO);
        return new ResponseEntity<>(updatedProductDTO,HttpStatus.OK);
    }

    @DeleteMapping("/admin/products/{productId}")
    public ResponseEntity<ProductDTO>deleteProduct(@PathVariable Long productId){
        ProductDTO productDTO = productService.deleteProduct(productId);
        return new ResponseEntity<>(productDTO, HttpStatus.OK);
    }

    @PutMapping("/public/product/{productId}/image")
    public ResponseEntity<ProductDTO>updateImage(@PathVariable Long productId,
                                                @RequestParam("Image")MultipartFile image){
        ProductDTO updatedDto = productService.updateImageById(productId,image);
        return new ResponseEntity<>(updatedDto, HttpStatus.OK);
    }
}
