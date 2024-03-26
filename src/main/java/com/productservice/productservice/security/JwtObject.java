package com.productservice.productservice.security;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;
@Getter
@Setter
public class JwtObject {
    //this is kind of a dto object
    private String email;
    private Long userId;
    private Date expiryAt;
    private Date createdAt;
    private List<Role> roles;
}
