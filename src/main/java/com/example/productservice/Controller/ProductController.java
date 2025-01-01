package com.example.productservice.Controller;

import com.example.productservice.DTO.ProductRequestDTO;
import com.example.productservice.DTO.ProductResponseDTO;
import com.example.productservice.Models.product;
import com.example.productservice.Services.FakeStoreProductService;
import com.example.productservice.Services.ProductService;
import com.example.productservice.Services.productNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {

    private final RestTemplate restTemplate;
    private ProductService productService;

    @Autowired
    public ProductController(@Qualifier("fakeStoreService") ProductService productService, RestTemplate restTemplate) {
        this.productService = productService;
        this.restTemplate = restTemplate;
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

//        return p.from();
        return ProductResponseDTO.giveBackToClient(p);
    }

    /* Patch is not working. Need to figure out the reason */
    @PatchMapping("/product/{id}")
    public ProductResponseDTO PartialUpdateProduct(@PathVariable("id") Long id,
                                     @RequestBody ProductRequestDTO requestDTO) throws productNotFoundException {
        product p = productService.updateProduct(id, requestDTO.getTitle(),
                requestDTO.getPrice(),
                requestDTO.getDescription(),
                requestDTO.getImage(),
                requestDTO.getCategory());

//        return p.from();
        return ProductResponseDTO.giveBackToClient(p);
    }

    @DeleteMapping("/product/{id}")
    public void deleteProduct(@PathVariable("id") Long id){
        productService.deleteProduct(id);
    }

    @GetMapping("/product/limitToFive")
    public List<ProductResponseDTO> getTop5Products(){
        List<product> products = productService.getTop5();

        List<ProductResponseDTO> productResponseDTOs = new ArrayList<>();
        for(product p: products){
            productResponseDTOs.add(p.from());
        }

        return productResponseDTOs;
    }
}
