package com.productservice.productservice.inheritanceRelations.joinedTable;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "joined_mentors")
@PrimaryKeyJoinColumn(name = "user_id")
public class Mentor extends User {
    private double avgRating;
}
