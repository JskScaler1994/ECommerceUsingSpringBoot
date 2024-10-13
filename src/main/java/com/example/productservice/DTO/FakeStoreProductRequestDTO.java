package com.example.productservice.DTO;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreProductRequestDTO {

    private String title;
    private double price;
    private String description;
    private String image;
    private String category;
}
