package com.productservice.productservice.controllers;

import com.productservice.productservice.dtos.GenericProductDto;
import com.productservice.productservice.exceptions.ProductNotFoundException;
import com.productservice.productservice.services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;
    //@Autowired  this is field injection one of the ways for dependency injection
    //constructor injection
    ProductController(@Qualifier("fakeStoreProductService") ProductService productService){
        this.productService = productService;
    }



    /*@Autowired eg of setter injection
    public void setProductService(ProductService productService) {
        this.productService = productService;
    } */

    @GetMapping("/{id}")
    public GenericProductDto getProductById(@PathVariable("id") Long id) throws ProductNotFoundException {
    //return "Product fetched with id " + id;
        return productService.getProductById(id);
    }
    @GetMapping
    public List<GenericProductDto> getAllProducts(){
       return  productService.getAllProducts();
    }
    @DeleteMapping("/{id}")
    public GenericProductDto deleteProductById(@PathVariable("id") Long id){
       return this.productService.deleteProductById(id);
    }
    @PostMapping
    public GenericProductDto createProduct(@RequestBody GenericProductDto genericProductDto){
        return productService.createProduct(genericProductDto);
    }
    @PatchMapping("/{id}")
    public GenericProductDto updateProductById(@PathVariable("id") Long id , @RequestBody GenericProductDto genericProductDto){
        return productService.updateProductById(id,genericProductDto);
    }
//@ExceptionHandler(ProductNotFoundException.class)
//    private ResponseEntity<ExceptionDto> handleProductNotFoundException(ProductNotFoundException productNotFoundException){
//        ExceptionDto exceptionDto = new ExceptionDto();
//        exceptionDto.setMessage(productNotFoundException.getMessage());
//        exceptionDto.setHttpStatus(HttpStatus.NOT_FOUND);
//
//        ResponseEntity responseEntity = new ResponseEntity(exceptionDto,HttpStatus.NOT_FOUND);
//
//        return responseEntity;
//    }
}

/*threre are three ways of doing  depenency injection
1 constructor injection
2 field injection  ---https://stackoverflow.com/questions/39890849/what-exactly-is-field-injection-and-how-to-avoid-it
3 settter injection
* */
