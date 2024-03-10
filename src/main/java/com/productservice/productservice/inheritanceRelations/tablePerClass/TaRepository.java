package com.productservice.productservice.inheritanceRelations.tablePerClass;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TaRepository extends JpaRepository<Ta,Long> {
    @Override
     Ta save(Ta ta);
}
