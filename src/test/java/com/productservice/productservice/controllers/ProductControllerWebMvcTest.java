package com.productservice.productservice.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.productservice.productservice.dtos.GenericProductDto;
import com.productservice.productservice.exceptions.ProductNotFoundException;
import com.productservice.productservice.services.ProductService;
import jakarta.inject.Inject;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

//@WebMvcTest it wont initialize the unnecessary dependency
@WebMvcTest(ProductController.class)
public class ProductControllerWebMvcTest {
    @MockBean
    private ProductService productService;

    @Inject
    private ProductController productController;

    @Inject
    private MockMvc mockMvc;
    @Inject
    private ObjectMapper objectMapper;

    @Captor
    private ArgumentCaptor<Long> argumentCaptor;


//    @Test
//    void testGetAllProductsReturnsEmptyList() throws Exception {
//        when(productService.getAllProducts())
//                .thenReturn(new ArrayList<>());
//
//        mockMvc.perform(get("/products"))
//                .andExpect(status().is(200))
//                .andExpect(content().string("[]"));
//
//
//    }
//@Test
//    void testGetAllProductsReturnsValidList() throws Exception {
//        List<GenericProductDto> genericProductDtos = new ArrayList<>();
//        genericProductDtos.add(new GenericProductDto());
//        genericProductDtos.add(new GenericProductDto());
//        genericProductDtos.add(new GenericProductDto());
//        when(productService.getAllProducts())
//                .thenReturn(genericProductDtos);
//
//        mockMvc.perform(get("/products"))
//                .andExpect(status().is(200))
//                .andExpect(content().string(objectMapper.writeValueAsString(genericProductDtos)));
//
//
//    }
//@Test
//    void createProductCreateAValidNewProduct() throws Exception {
//        GenericProductDto productToCreateDto = new GenericProductDto();
//        productToCreateDto.setTitle("MacBook:");
//        productToCreateDto.setPrice(200000);
//        productToCreateDto.setDescription("Fastest mac ever:");
//        productToCreateDto.setCategory("Laptop");
//
//        GenericProductDto outputGenericProductDto = new GenericProductDto();
//        outputGenericProductDto.setCategory(productToCreateDto.getCategory());
//        outputGenericProductDto.setTitle((productToCreateDto.getTitle()));
//        outputGenericProductDto.setDescription(productToCreateDto.getDescription());
//        outputGenericProductDto.setPrice((productToCreateDto.getPrice()));
//        outputGenericProductDto.setId(1000L);
//
//        when(productService.createProduct(any()))
//                .thenReturn(outputGenericProductDto);
//
//        mockMvc.perform(post("/products")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(objectMapper.writeValueAsString(productToCreateDto))
//        )
//                .andExpect(status().is(200))
//                .andExpect(
//                    content().string(objectMapper.writeValueAsString(outputGenericProductDto))
//                    )
//                .andExpect(jsonPath("$.title" ,is("Macbook")))
//                .andExpect(jsonPath("$.price", is(200000L)));
//    }

//    @Test
//    @DisplayName("testProductControllerCallsProductServiceWithSameProductIdAsInput")
//void testIfSameInput() throws ProductNotFoundException {
//        //check product controller is passing same productid to service
//        //productService as input
//        Long id = 100L;
//
//        when(productService.getProductById(id)).thenReturn(new GenericProductDto());
//
//        GenericProductDto genericProductDto = productController.getProductById(id);
//
//        verify(productService).getProductById(argumentCaptor.capture());
//
//
//        assertEquals(id,argumentCaptor.getValue());
//    }

}
