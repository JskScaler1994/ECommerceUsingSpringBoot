package com.example.productservice.Repo;

import com.example.productservice.Models.product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<product, Long> {
    product save(product p);

    List<product> findAll();

    Optional<product> findById(long id);
}
