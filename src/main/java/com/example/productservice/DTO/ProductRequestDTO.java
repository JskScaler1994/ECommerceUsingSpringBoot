package com.example.productservice.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductRequestDTO {
    private String title;
    private String description;
    private double price;
    private String image;
    private String category;
}
