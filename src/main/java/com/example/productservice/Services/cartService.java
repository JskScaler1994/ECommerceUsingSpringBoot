package com.example.productservice.Services;

import com.example.productservice.Models.cart;
import org.springframework.stereotype.Service;

public interface cartService {
    public cart getCartbyId(long id);
}
