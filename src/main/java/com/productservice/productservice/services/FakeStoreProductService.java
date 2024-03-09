package com.productservice.productservice.services;

import com.productservice.productservice.dtos.FakeStoreProductDto;
import com.productservice.productservice.dtos.GenericProductDto;
import com.productservice.productservice.exceptions.ProductNotFoundException;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service("fakeStoreProductService")
public class FakeStoreProductService implements ProductService{
    private RestTemplateBuilder restTemplateBuilder;
    private String specificProductUrl = "https://fakestoreapi.com/products/{id}";
    private String genericProductUrl = "https://fakestoreapi.com/products/";
    FakeStoreProductService(RestTemplateBuilder restTemplateBuilder){
        this.restTemplateBuilder = restTemplateBuilder;
    }

    private static GenericProductDto convertToGenericProductDto(FakeStoreProductDto fakeStoreProductDto){
        GenericProductDto genericProductDto = new GenericProductDto();
        genericProductDto.setId(fakeStoreProductDto.getId());
        genericProductDto.setTitle(fakeStoreProductDto.getTitle());
        genericProductDto.setPrice(fakeStoreProductDto.getPrice());
        genericProductDto.setDescription(fakeStoreProductDto.getDescription());
        genericProductDto.setCategory(fakeStoreProductDto.getCategory());
        genericProductDto.setImage(fakeStoreProductDto.getImage());
        return genericProductDto;
    }
    @Override
    public GenericProductDto getProductById(Long id) throws ProductNotFoundException {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> responseEntity =
                restTemplate.getForEntity(specificProductUrl, FakeStoreProductDto.class,id);
        //convert fakestore productdto to genericproductdto before return

        FakeStoreProductDto fakeStoreProductDto = responseEntity.getBody();
        if(fakeStoreProductDto == null){
            throw new ProductNotFoundException("Product with id :" + id + "Not Found");
        }

        return convertToGenericProductDto(responseEntity.getBody());
    }

    @Override
    public List<GenericProductDto> getAllProducts() {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto[]> responseEntity=
        restTemplate.getForEntity(genericProductUrl,FakeStoreProductDto[].class);
        List<GenericProductDto> result = new ArrayList<>();
        List<FakeStoreProductDto>  fakeStoreProductDtos = List.of(responseEntity.getBody());

        for(FakeStoreProductDto fakeStoreProductDto : fakeStoreProductDtos){
            result.add(convertToGenericProductDto(fakeStoreProductDto));
        }
        return result;
    }

    @Override
    public GenericProductDto deleteProductById(Long id) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        RequestCallback requestCallback = restTemplate.acceptHeaderRequestCallback(FakeStoreProductDto.class);
        ResponseExtractor<ResponseEntity<FakeStoreProductDto>> responseExtractor =
                restTemplate.responseEntityExtractor(FakeStoreProductDto.class);

        ResponseEntity<FakeStoreProductDto> responseEntity = restTemplate.execute(specificProductUrl, HttpMethod.DELETE, requestCallback, responseExtractor, id);
        return convertToGenericProductDto(responseEntity.getBody());
    }

    @Override
    public GenericProductDto createProduct(GenericProductDto genericProductDto) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> responseEntity =
        restTemplate.postForEntity(genericProductUrl,genericProductDto,FakeStoreProductDto.class);
    return convertToGenericProductDto(responseEntity.getBody());
    }

    @Override
    public GenericProductDto updateProductById(Long id, GenericProductDto genericProductDto) {
//        RestTemplate restTemplate = restTemplateBuilder.build();
//        ResponseEntity<FakeStoreProductDto> responseEntity =
//                restTemplate.patchForObject(specificProductUrl,genericProductDto,FakeStoreProductDto.class,id,genericProductDto);

        return null;
    }
}
