package com.productservice.productservice.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Product extends BaseModel{
    private String title;
    private String description;
    private String image;
    @ManyToOne(optional = false)
    private Category category;
    //category is not a primitive attribute  its a relation
@OneToOne( cascade = {CascadeType.REMOVE,CascadeType.PERSIST})
private Price price;
private int inventotyCount;
}

/*
 1              1
product   --- category
 M               1
*
* */
