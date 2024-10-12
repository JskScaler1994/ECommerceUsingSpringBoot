package com.example.productservice.Services;

import com.example.productservice.DTO.FakeStoreResponseDTO;
import com.example.productservice.Models.product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class FakeStoreProductService implements ProductService{

    private RestTemplate restTemplate;

    @Autowired
    public FakeStoreProductService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    @Override
    public product getProductById(long id) {
        FakeStoreResponseDTO responseDTO = restTemplate.getForObject(
                "https://fakestoreapi.com/products/" + id, FakeStoreResponseDTO.class);

        return responseDTO.toProduct();
    }

    @Override
    public List<product> getAllProducts() {

        return List.of();
    }


}
