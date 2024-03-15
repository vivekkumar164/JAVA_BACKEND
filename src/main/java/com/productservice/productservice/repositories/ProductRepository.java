package com.productservice.productservice.repositories;

import com.productservice.productservice.models.Product;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {
    @Override
    List<Product> findAll();


    List<Product> findAllByTitle(String title);

    List<Product> findAllByTitleAndDescription(String title , String desc);

    List<Product> findAllByPrice_ValueLessThan(Integer x);

@Query(value = "select * from product where id = 1" ,  nativeQuery = true)
    List<Product> findAllByPrice_ValueBetween(Integer x,Integer y);
}
