package com.productservice.productservice.controllers;

import com.productservice.productservice.exceptions.ProductNotFoundException;
import com.productservice.productservice.thirdPartyClients.fakeStoreClient.FakeStoreClient.FakeStoreClient;
import jakarta.inject.Inject;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

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
}
