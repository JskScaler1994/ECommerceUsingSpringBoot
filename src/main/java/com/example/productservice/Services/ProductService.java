package com.example.productservice.Services;

import com.example.productservice.Models.product;

import java.util.List;

public interface ProductService {
    public product getProductById(long id);
    public List<product> getAllProducts();
}
