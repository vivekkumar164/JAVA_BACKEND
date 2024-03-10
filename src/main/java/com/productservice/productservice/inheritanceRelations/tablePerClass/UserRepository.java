package com.productservice.productservice.inheritanceRelations.tablePerClass;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    @Override
     User save(User user);
}
