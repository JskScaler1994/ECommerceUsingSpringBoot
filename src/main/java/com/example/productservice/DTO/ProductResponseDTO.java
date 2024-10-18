package com.example.productservice.DTO;

import com.example.productservice.Models.category;
import com.example.productservice.Models.product;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ProductResponseDTO {
    private long id;
    private String title;
    private Double price;
    private String description;
    private String category;

    public static ProductResponseDTO giveBackToClient(product p){
        ProductResponseDTO responseDTO = new ProductResponseDTO();
        responseDTO.setId(p.getId());
        responseDTO.setTitle(p.getTitle());
        responseDTO.setPrice(p.getPrice());
        responseDTO.setDescription(p.getDescription());
        responseDTO.setCategory(p.getCategory().getName());

        return responseDTO;
    }
}
