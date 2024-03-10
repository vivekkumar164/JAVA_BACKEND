package com.productservice.productservice.inheritanceRelations.singleTable;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Entity(name = "st_user")
@DiscriminatorColumn(
        name = "user_type" ,
        discriminatorType = DiscriminatorType.INTEGER
)
@DiscriminatorValue(value="0")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String Email;


}
