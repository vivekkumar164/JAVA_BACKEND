package com.productservice.productservice.inheritanceRelations.singleTable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("st_student")
public interface StudentRepository extends JpaRepository<Student,Long> {
    @Override
    <S extends Student> S save(S entity);
}
