package com.example.productservice.Repo;

import com.example.productservice.Models.category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<category, Long> {

    Optional<category> findByName(String name);

    category save(category category);
}
