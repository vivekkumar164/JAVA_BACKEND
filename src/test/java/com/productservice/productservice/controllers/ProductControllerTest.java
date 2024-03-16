package com.productservice.productservice.controllers;

import com.productservice.productservice.dtos.GenericProductDto;
import com.productservice.productservice.exceptions.ProductNotFoundException;
import com.productservice.productservice.services.ProductService;
import com.productservice.productservice.thirdPartyClients.fakeStoreClient.FakeStoreClient.FakeStoreClient;
import jakarta.inject.Inject;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class ProductControllerTest {
    @Inject
    private ProductController productController;
//
//    ProductControllerTest(ProductController productController){
//        this.productController = productController;
//    }
   @Inject
    private FakeStoreClient fakeStoreClient;
//        ProductControllerTest(FakeStoreClient fakeStoreClient){
//        this.fakeStoreClient = fakeStoreClient;
//    }
@MockBean
    private ProductService productService;

    @Test
    @DisplayName("Testing 1 + 1 is 2")
    void testOnePlusOneIsTwoOrNot(){
        assertTrue(1==2, "1 is not equal to 2");
        //assertEquals(11,1+1,"1 + 1 should be true:");
        //assert (2 == 1 + 1);
        //checks the expected value 2 vs the output expression
        //if assert is true , testcase succeeds else fail
    }
@Test
    void testGetProductByIdNegativeTc() {
        assertThrows(ProductNotFoundException.class,() -> productController.getProductById(100L));

    }
@Test
    void testGetProductByIdMocking() throws ProductNotFoundException {
    GenericProductDto genericProductDto = new GenericProductDto();
        when(productService.getProductById(any(Long.class))).thenReturn(genericProductDto);

        //assertNull(productService.getProductById(100L));
        assertEquals(genericProductDto,productService.getProductById(1000L));
    }
@Test
    void testGetProductByIdMockingException() throws ProductNotFoundException {
        when(productService.getProductById(1L))
                .thenThrow(ProductNotFoundException.class);
        assertThrows(ProductNotFoundException.class,() -> productController.getProductById(1L));
    }
}
