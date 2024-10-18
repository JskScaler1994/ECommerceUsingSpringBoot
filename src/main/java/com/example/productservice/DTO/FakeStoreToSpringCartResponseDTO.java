package com.example.productservice.DTO;

import com.example.productservice.Models.cart;
import com.example.productservice.Models.product;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Getter
@Setter
public class FakeStoreToSpringCartResponseDTO {
    private long id;
    private long UserId;
    private Date date;
    private List<product> products;

    public cart convertResponseToCart(){
        cart c = new cart();
        c.setId(id);
        c.setUserId(UserId);
        c.setDate(date);
        c.setProducts(products);


        return c;
    }
}