package com.example.productservice.Controller;

import com.example.productservice.DTO.ProductResponseDTO;
import com.example.productservice.Models.product;
import com.example.productservice.Services.FakeStoreProductService;
import com.example.productservice.Services.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    private FakeStoreProductService productService;

    public ProductController(FakeStoreProductService productService) {
        this.productService = productService;
    }


    @GetMapping("/product")
    public String getProducts(){

        return "Hello";
    }

    @GetMapping("/product/{id}")
    public ProductResponseDTO getProductbyId(@PathVariable("id") Long id){
        product p = productService.getProductById(id);
        return p.from();
    }

    public void createProduct(){

    }

    public void updateProduct(){

    }

    public void deleteProduct(){

    }
}
