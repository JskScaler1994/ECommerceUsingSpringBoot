package com.example.productservice.DTO;

import com.example.productservice.Models.category;
import com.example.productservice.Models.product;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ProductResponseDTO {
    private long id;
    private String name;
    private Double price;
    private String description;
    private String category;
}
