package com.example.productservice.Services;

import com.example.productservice.DTO.FakeStoreToSpringCartResponseDTO;
import com.example.productservice.Models.cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class FakeStoreCartService implements cartService{

    RestTemplate restTemplate;

    @Autowired
    public FakeStoreCartService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    @Override
    public cart getCartbyId(long id) {
        FakeStoreToSpringCartResponseDTO responseDTO = restTemplate.getForObject("https://fakestoreapi.com/carts/" + id,
                FakeStoreToSpringCartResponseDTO.class);

        return responseDTO.convertResponseToCart();
    }
}
