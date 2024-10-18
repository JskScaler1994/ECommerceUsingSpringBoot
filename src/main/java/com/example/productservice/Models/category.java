package com.example.productservice.Models;


import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class category extends BaseModel {
    private String name;
    private String description;

//    @OneToMany
//    private List<product> featuredProducts;

    @OneToMany(mappedBy = "category")
    private List<product> products;
}
