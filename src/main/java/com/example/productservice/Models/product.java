package com.example.productservice.Models;



import com.example.productservice.DTO.ProductResponseDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class product {
    private Long id;
    private String title;
    private String description;
    private Double price;
    private String imageUrl;
    private category category;

    public ProductResponseDTO from(){
        ProductResponseDTO dto = new ProductResponseDTO();
        dto.setId(this.id);
        dto.setName(this.title);
        dto.setPrice(this.price);
        dto.setDescription(this.description);
        dto.setCategory(category.getName());

        return dto;
    }
}
