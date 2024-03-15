package com.productservice.productservice.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Category extends BaseModel{
@Column(nullable = false)
private String name;
@OneToMany( mappedBy = "category")
private List<Product> products;
}
