package com.productservice.productservice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Product extends BaseModel{
    private String title;
    private String description;
    private String image;
    @ManyToOne(optional = false)
    @JoinColumn(nullable = false)
    private Category category;
    //category is not a primitive attribute  its a relation
@OneToOne(optional = false)
@JoinColumn(nullable = false)
private Price price;
}

/*
 1              1
product   --- category
 M               1
*
* */
