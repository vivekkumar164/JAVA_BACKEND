package com.productservice.productservice.inheritanceRelations.joinedTable;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Inheritance(strategy = InheritanceType.JOINED)
@Entity(name="joined_user")
public class User {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String Email;


}
