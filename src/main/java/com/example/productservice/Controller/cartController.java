package com.example.productservice.Controller;

import com.example.productservice.DTO.springToFrontResponseCartDTO;
import com.example.productservice.Models.cart;
import com.example.productservice.Services.cartService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class cartController {

    private cartService service;
    private RestTemplate restTemplate;

    public cartController(cartService service, RestTemplate restTemplate){
        this.service = service;
        this.restTemplate = restTemplate;
    }


    @GetMapping("/cart/{id}")
    public springToFrontResponseCartDTO getCartById(@PathVariable("id") long id){
        cart c = service.getCartbyId(id);
        springToFrontResponseCartDTO response = new springToFrontResponseCartDTO();
        return response.convertCartToResponse(c);
    }
}
