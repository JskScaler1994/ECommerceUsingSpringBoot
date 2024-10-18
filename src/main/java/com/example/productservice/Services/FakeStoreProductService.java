package com.example.productservice.Services;

import com.example.productservice.DTO.FakeStoreProductRequestDTO;
import com.example.productservice.DTO.FakeStoreProductResponseDTO;
import com.example.productservice.DTO.ProductRequestDTO;
import com.example.productservice.Models.product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class FakeStoreProductService implements ProductService{

    private RestTemplate restTemplate;

    @Autowired
    public FakeStoreProductService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    @Override
    public product getProductById(long id) throws productNotFoundException{
        FakeStoreProductResponseDTO responseDTO = restTemplate.getForObject(
                "https://fakestoreapi.com/products/" + id, FakeStoreProductResponseDTO.class);

        if(responseDTO == null){
            throw new productNotFoundException("Product not found");
        }
        return responseDTO.toProduct();
    }

    @Override
    public List<product> getAllProducts() {
        FakeStoreProductResponseDTO[] responseDTOS = restTemplate.getForObject(
                "https://fakestoreapi.com/products", FakeStoreProductResponseDTO[].class
        );

        List<product> products = new ArrayList<>();
        for(FakeStoreProductResponseDTO responseDTO: responseDTOS){
            products.add(responseDTO.toProduct());
        }

        return products;
    }

    @Override
    public product createProduct(String title, Double price, String description,
                                 String image, String category) {

        FakeStoreProductRequestDTO requestDTO = new FakeStoreProductRequestDTO();
        requestDTO.setTitle(title);
        requestDTO.setPrice(price);
        requestDTO.setImage(image);
        requestDTO.setCategory(category);
        requestDTO.setDescription(description);

        FakeStoreProductResponseDTO responseDTO = restTemplate.postForObject(
                "https://fakestoreapi.com/products",
                requestDTO,
                FakeStoreProductResponseDTO.class
        );

        return responseDTO.toProduct();
    }

    @Override
    public void deleteProduct(long id){
        restTemplate.delete("https://fakestoreapi.com/products/" + id);
    }

    @Override
    public product updateProduct(long id, String title, Double price, String description,
                                 String image, String category) {
        FakeStoreProductRequestDTO requestDTO = new FakeStoreProductRequestDTO();
        requestDTO.setTitle(title);
        requestDTO.setPrice(price);

        HttpEntity<FakeStoreProductRequestDTO> httpEntity= new HttpEntity<>(requestDTO);

        HttpEntity<FakeStoreProductResponseDTO> responseDTOHttpEntity =
                restTemplate.exchange("https://fakestoreapi.com/products/" + id,
                HttpMethod.PATCH,
                httpEntity,
                FakeStoreProductResponseDTO.class
        );

        return responseDTOHttpEntity.getBody().toProduct();
    }
}
