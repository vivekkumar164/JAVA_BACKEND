package com.productservice.productservice.services;

import com.productservice.productservice.dtos.GenericProductDto;
import com.productservice.productservice.dtos.UserDto;
import com.productservice.productservice.exceptions.ProductNotFoundException;
import com.productservice.productservice.models.Product;
//import com.productservice.productservice.repositories.OpenSearchProductRepository;
import com.productservice.productservice.repositories.ProductRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Primary
@Service

public class SelfProductServiceImpl implements ProductService {
   // private  OpenSearchProductRepository openSearchProductRepository;
    private ProductRepository productRepository;
    private RestTemplate restTemplate;

    SelfProductServiceImpl(ProductRepository productRepository,RestTemplate restTemplate){
        this.productRepository = productRepository;
        this.restTemplate = restTemplate;
    }
    @Override
    public GenericProductDto getProductById(String authToken , Long id) throws ProductNotFoundException {
       GenericProductDto genericProductDto = new GenericProductDto();
//        Optional<Product> optionalProduct = productRepository.findById(UUID.fromString("670262b1-4895-4795-b985-f857a3531357"));
//        Product product = optionalProduct.get();
//        genericProductDto.setDescription(product.getDescription());
//        genericProductDto.setTitle(product.getTitle());
//        genericProductDto.setImage(product.getImage());
//        genericProductDto.setCategory(product.getCategory().toString());
//        genericProductDto.setPrice(0);
//        return genericProductDto;
        //RestTemplate restTemplate = new RestTemplate();
        //restTemplate.getForEntity("http://localhost:4000/users/1", UserDto.class);
        ResponseEntity<UserDto> responseEntity = restTemplate.getForEntity("http://userservice/users/1", UserDto.class);
        return genericProductDto;
    }

    @Override
    public List<GenericProductDto> getAllProducts() {
        return null;
    }

    @Override
    public GenericProductDto deleteProductById(Long id) {
        return null;
    }

    @Override
    public GenericProductDto createProduct(GenericProductDto genericProductDto) {
        Product product = new Product();
        product.setTitle(genericProductDto.getTitle());
        product.setImage(genericProductDto.getImage());

        Product savedProduct = productRepository.save(product);
       // openSearchProductRepository.save(savedProduct);
        return null;
    }

    @Override
    public GenericProductDto updateProductById(Long id, GenericProductDto genericProductDto) {
        return null;
    }
}
