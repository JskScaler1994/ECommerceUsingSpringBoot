package com.example.productservice.Repo;

import com.example.productservice.Models.category;
import com.example.productservice.Models.product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<product, Long> {
    product save(product p);

    List<product> findAll();

    Optional<product> findById(long id);

    void deleteById(Long id);

    List<product> findByCategory(category category);

    /* We are using SQL native query here */
    @Query(value = "select * from product where product.category_id = id", nativeQuery = true)
    List<product> findByCategoryId(long id);

    /* We are using JPA query itself instead of SQL query */
    @Query(value = "select p from product p where p.category.id = :id")
    List<product> findByCategoryId_2(long id);

}
