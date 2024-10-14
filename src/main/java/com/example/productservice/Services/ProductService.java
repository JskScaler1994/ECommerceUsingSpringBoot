package com.example.productservice.Services;

import com.example.productservice.Models.product;

import java.util.List;

public interface ProductService {
    public product getProductById(long id) throws productNotFoundException;
    public List<product> getAllProducts();
    public product createProduct(String title, Double price, String description,
                                 String image, String category);
}
