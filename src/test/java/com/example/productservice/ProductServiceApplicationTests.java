package com.example.productservice;

import com.example.productservice.Models.category;
import com.example.productservice.Models.product;
import com.example.productservice.Repo.CategoryRepository;
import com.example.productservice.Repo.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

@SpringBootTest
class ProductServiceApplicationTests {

    /* We are interacting with repo directly */
    @Autowired
    ProductRepository productRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Test
    void contextLoads() {
    }


    /* We can run the method independently without going through
     * Controller, service etc., by using the @Test annotation */
    @Test
    public void findById() {
        Optional<product> p = productRepository.findById(1);
        System.out.println(p.get().getTitle());
    }

    /* Two queries are fired in the below method,
    *  1. For getting the category
    *  2. For getting the products */
    @Test
    public void findByCategory(){
        Optional<category> category = categoryRepository.findByName("Book");
        List<product> products = productRepository.findByCategory(category.get());
        System.out.println(products);
    }

    /* FindByCategoryId method using SQL query, overriding
    *  JPA query */
    @Test
    public void findByCategoryId(){
        List<product> products = productRepository.findByCategoryId(1L);
        System.out.println(products);
    }

    /* In this method, we are using custom JPA query instead of
    *  SQL query */
    @Test
    public void findByCategoryId2(){
        List<product> products = productRepository.findByCategoryId(1L);
        System.out.println(products);
    }

}
