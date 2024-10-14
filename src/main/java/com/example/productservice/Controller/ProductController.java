package com.example.productservice.Controller;

import com.example.productservice.DTO.ProductRequestDTO;
import com.example.productservice.DTO.ProductResponseDTO;
import com.example.productservice.Models.product;
import com.example.productservice.Services.FakeStoreProductService;
import com.example.productservice.Services.ProductService;
import com.example.productservice.Services.productNotFoundException;
import org.springframework.web.bind.annotation.*;

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
    public ProductResponseDTO getProductbyId(@PathVariable("id") Long id) throws productNotFoundException {
        product p = productService.getProductById(id);
        return p.from();
    }

    @PostMapping("/product")
    public ProductResponseDTO createProduct(@RequestBody ProductRequestDTO requestDTO){

        product p = productService.createProduct(
                requestDTO.getTitle(),
                requestDTO.getPrice(),
                requestDTO.getDescription(),
                requestDTO.getImage(),
                requestDTO.getCategory()
        );

        return p.from();
    }

    public void PartialupdateProduct(){

    }

    public void deleteProduct(){

    }
}
