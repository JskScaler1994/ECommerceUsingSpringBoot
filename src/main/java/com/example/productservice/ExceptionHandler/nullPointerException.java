package com.example.productservice.ExceptionHandler;

import com.example.productservice.DTO.ErrorDTO;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice
@RestController
public class nullPointerException {

    @ExceptionHandler(NullPointerException.class)
    public ErrorDTO nullPointerException(NullPointerException e) {
        ErrorDTO dto = new ErrorDTO();
        dto.setMessage("Null Pointer Exception");
        dto.setStatus("Failure");

        return dto;
    }
}
