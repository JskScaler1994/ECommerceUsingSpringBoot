package com.example.productservice.Services;

import com.example.productservice.Models.product;
import com.example.productservice.Repo.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ProductDBService")
public class ProductDBService implements ProductService {

    ProductRepository productRepository;

    @Override
    public product getProductById(long id) throws productNotFoundException {
        return null;
    }

    @Override
    public List<product> getAllProducts() {
        return List.of();
    }

    @Override
    public product createProduct(String title, Double price, String description, String image, String category) {
        return null;
    }

    @Override
    public void deleteProduct(long id) {

    }

    @Override
    public product updateProduct(long id, String title, Double price, String description, String image, String category) {
        return null;
    }

    @Override
    public List<product> getTop5() {
        return List.of();
    }
}
