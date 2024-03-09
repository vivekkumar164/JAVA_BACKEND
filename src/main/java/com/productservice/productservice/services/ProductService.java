package com.productservice.productservice.services;

import com.productservice.productservice.dtos.FakeStoreProductDto;
import com.productservice.productservice.dtos.GenericProductDto;
import com.productservice.productservice.exceptions.ProductNotFoundException;

import java.util.List;

public interface ProductService {
     GenericProductDto getProductById(Long id) throws ProductNotFoundException;
     List<GenericProductDto> getAllProducts();
     GenericProductDto deleteProductById(Long id);
     GenericProductDto createProduct(GenericProductDto genericProductDto);
     GenericProductDto updateProductById(Long id, GenericProductDto genericProductDto);


}
