package com.productservice.productservice.models;

import com.productservice.productservice.dtos.GenericProductDto;
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

    public GenericProductDto from(Product product) {
        GenericProductDto genericProductDto = new GenericProductDto();
        genericProductDto.setTitle(product.getTitle());
        genericProductDto.setDescription(product.getDescription());
        //genericProductDto.setPrice(product.getPrice());
        genericProductDto.setImage(product.getImage());
        //genericProductDto.setId(product.getId());
        genericProductDto.setInventoryCount(product.getInventotyCount());
        return genericProductDto;
    }
}

/*
 1              1
product   --- category
 M               1
*
* */
