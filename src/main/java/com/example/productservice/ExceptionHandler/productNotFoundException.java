package com.example.productservice.ExceptionHandler;

import com.example.productservice.DTO.ErrorDTO;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice
@RestController
public class productNotFoundException {

    @ExceptionHandler(com.example.productservice.Services.productNotFoundException.class)
    public ErrorDTO productNotFound(com.example.productservice.Services.productNotFoundException e) {
        ErrorDTO dto = new ErrorDTO();
        dto.setMessage("Product Not Found");
        dto.setStatus("Failure");

        return dto;
    }
}
