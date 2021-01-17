package com.study.jpaSpecification.repository;

import com.study.jpaSpecification.domain.User;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository
        extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {

    List<User> findAll (Specification<User> userSpecification);
}
