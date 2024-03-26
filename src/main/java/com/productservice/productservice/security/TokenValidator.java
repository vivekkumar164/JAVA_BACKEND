package com.productservice.productservice.security;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Component
public class TokenValidator {
    private RestTemplateBuilder restTemplateBuilder;
            TokenValidator(RestTemplateBuilder restTemplateBuilder){
                this.restTemplateBuilder = restTemplateBuilder;
            }
    /**
     * this method should call the userservice to validate the token
     * if token is valid return the corresponding object
     * else return empty
     * @param token
     * @return
     */
    public Optional<JwtObject> validateToken(String token){
        RestTemplate restTemplate = restTemplateBuilder.build();
        //make http call to userService --> validateToken method
        return Optional.empty();
    }
}
