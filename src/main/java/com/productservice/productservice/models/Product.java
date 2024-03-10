package com.productservice.productservice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Product extends BaseModel{
    private String title;
    private String description;
    private int price;
    private String image;
    @ManyToOne
    private Category category;
    //category is not a primitive attribute  its a relation
}

/*
 1              1
product   --- category
 M               1
*
* */
