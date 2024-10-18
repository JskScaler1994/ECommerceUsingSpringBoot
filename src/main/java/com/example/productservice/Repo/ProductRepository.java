package com.example.productservice.Repo;

import com.example.productservice.Models.product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<product, Long> {
    product save(product p);
}
