package com.productservice.productservice.services;

import com.productservice.productservice.dtos.FakeStoreProductDto;
import com.productservice.productservice.dtos.GenericProductDto;
import com.productservice.productservice.exceptions.ProductNotFoundException;
import com.productservice.productservice.security.JwtObject;
import com.productservice.productservice.security.TokenValidator;
import com.productservice.productservice.thirdPartyClients.fakeStoreClient.FakeStoreClient.FakeStoreClient;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//@Primary
@Service("fakeStoreProductService")
public class FakeStoreProductService implements ProductService{


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

    private FakeStoreClient fakeStoreAdapter;
    private TokenValidator tokenValidator;

    private RedisTemplate<String,FakeStoreProductDto> redisTemplate;

    FakeStoreProductService(FakeStoreClient fakeStoreAdapter
    ,TokenValidator tokenValidator,RedisTemplate redisTemplate){
        this.fakeStoreAdapter = fakeStoreAdapter;
        this.tokenValidator = tokenValidator;
        this.redisTemplate =redisTemplate;
    }
    @Override
    public GenericProductDto getProductById(String authToken , Long id) throws ProductNotFoundException {
        System.out.println(authToken);
        Optional<JwtObject> jwtObjectOptional = tokenValidator.validateToken(authToken);
//        if(jwtObjectOptional.isEmpty()){
//            //invalid token
//            //reject the request
//
//        }
//            JwtObject jwtObject = jwtObjectOptional.get();
            //Long userId = jwtObject.getUserId();
        FakeStoreProductDto fakeStoreProductDto = (FakeStoreProductDto) redisTemplate.opsForHash().get("PRODUCTS", id);

        if (fakeStoreProductDto != null) {
            return convertToGenericProductDto(fakeStoreProductDto);
        }

        fakeStoreProductDto = fakeStoreAdapter.getProductById(id);
        redisTemplate.opsForHash().put("PRODUCTS", id, fakeStoreProductDto);
        return convertToGenericProductDto(fakeStoreProductDto);


    }

    @Override
    public List<GenericProductDto> getAllProducts() {

        List<FakeStoreProductDto> fakeStoreProductDtos =
                fakeStoreAdapter.getAllProducts();
        List<GenericProductDto> genericProductDtos = new ArrayList<>();
        for(FakeStoreProductDto fakeStoreProductDto : fakeStoreProductDtos){
            genericProductDtos.add(convertToGenericProductDto(fakeStoreProductDto));
        }
        return genericProductDtos;
    }

    @Override
    public GenericProductDto deleteProductById(Long id) {
        return convertToGenericProductDto(fakeStoreAdapter.deleteProductById(id));
    }

    @Override
    public GenericProductDto createProduct(GenericProductDto genericProductDto) {

    return convertToGenericProductDto(fakeStoreAdapter.createProduct(genericProductDto));
    }

    @Override
    public GenericProductDto updateProductById(Long id, GenericProductDto genericProductDto) {
//        RestTemplate restTemplate = restTemplateBuilder.build();
//        ResponseEntity<FakeStoreProductDto> responseEntity =
//                restTemplate.patchForObject(specificProductUrl,genericProductDto,FakeStoreProductDto.class,id,genericProductDto);

        return null;
    }
}
