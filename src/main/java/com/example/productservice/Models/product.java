package com.example.productservice.Models;



import com.example.productservice.DTO.ProductResponseDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class product extends BaseModel {
    private String title;
    private String description;
    private Double price;
    private String imageUrl;
    @ManyToOne
    private category category;

    public ProductResponseDTO from(){
        ProductResponseDTO dto = new ProductResponseDTO();
//        dto.setId(this.id);
        dto.setTitle(this.title);
        dto.setPrice(this.price);
        dto.setDescription(this.description);
        dto.setCategory(category.getName());

        return dto;
    }
}
