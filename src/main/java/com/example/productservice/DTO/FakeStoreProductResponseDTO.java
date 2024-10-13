package com.example.productservice.DTO;

import com.example.productservice.Models.category;
import com.example.productservice.Models.product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreProductResponseDTO {
    private long id;
    private String title;
    private String price;
    private String Category;
    private String description;
    private String image;

    public product toProduct(){
        product p = new product();
        p.setId(this.id);
        p.setTitle(this.title);
        p.setPrice(Double.valueOf(price));
        p.setImageUrl(this.image);
        p.setDescription(this.description);

        category c = new category();
        c.setName(this.Category);

        p.setCategory(c);

        return p;
    }
}
