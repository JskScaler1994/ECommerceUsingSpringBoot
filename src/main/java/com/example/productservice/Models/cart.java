package com.example.productservice.Models;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;


@Getter
@Setter
public class cart {
    private long id;
    private long userId;
    private Date date;
    private List<product> products;
}
