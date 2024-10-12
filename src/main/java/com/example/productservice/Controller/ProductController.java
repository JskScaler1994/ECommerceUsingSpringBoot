package com.example.productservice.Controller;

import com.example.productservice.DTO.ProductResponseDTO;
import com.example.productservice.Models.product;
import com.example.productservice.Services.FakeStoreProductService;
import com.example.productservice.Services.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {

    private FakeStoreProductService productService;

    public ProductController(FakeStoreProductService productService) {
        this.productService = productService;
    }


    @GetMapping("/product")
    public List<ProductResponseDTO> getProducts(){
        List<product> products = productService.getAllProducts();

        List<ProductResponseDTO> productResponseDTOs = new ArrayList<>();
        for(product p: products){
            productResponseDTOs.add(p.from());
        }

        return productResponseDTOs;
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
