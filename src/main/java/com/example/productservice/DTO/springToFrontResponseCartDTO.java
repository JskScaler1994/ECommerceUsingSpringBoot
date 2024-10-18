package com.example.productservice.DTO;

import com.example.productservice.Models.cart;
import com.example.productservice.Models.product;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;


@Getter
@Setter
public class springToFrontResponseCartDTO {
    private long id;
    private long userId;
    private Date date;
    private List<product> products;

    public springToFrontResponseCartDTO convertCartToResponse(cart c){
        springToFrontResponseCartDTO  response = new springToFrontResponseCartDTO();
        response.setUserId(c.getUserId());
        response.setDate(c.getDate());
        response.setProducts(c.getProducts());
        response.setId(c.getId());

        return response;
    }
}
