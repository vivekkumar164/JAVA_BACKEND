package com.productservice.productservice.controllers;

import com.productservice.productservice.dtos.ExceptionDto;
import com.productservice.productservice.exceptions.ProductNotFoundException;
import com.productservice.productservice.exceptions.HandleArrayIndexOutOfBoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ProductControllerAdvices {
    @ExceptionHandler(ProductNotFoundException.class)
//    @ResponseStatus(HttpStatus.NOT_FOUND)
//    @ResponseBody()
    private ResponseEntity<ExceptionDto> handleProductNotFoundException(ProductNotFoundException productNotFoundException) {
        ExceptionDto exceptionDto = new ExceptionDto();
        exceptionDto.setMessage(productNotFoundException.getMessage());
        exceptionDto.setHttpStatus(HttpStatus.NOT_FOUND);


        return new ResponseEntity<>(exceptionDto, HttpStatus.BAD_REQUEST);
    }


//
//    @ExceptionHandler(HandleArrayIndexOutOfBoundException.class)
//    private ResponseEntity<ExceptionDto> handleArrayIndexOutOfBoundException(HandleArrayIndexOutOfBoundException handleArrayIndexOutOfBoundException)
//    {
//        return null;
//    }
//@ExceptionHandler(NullPointerException.class)
//    private ResponseEntity<ExceptionDto> handleNullPointerException(NullPointerException nullPointerException){
//    return null;
//
//    }

}
