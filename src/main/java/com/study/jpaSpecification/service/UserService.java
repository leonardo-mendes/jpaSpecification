package com.study.jpaSpecification.service;

import com.study.jpaSpecification.domain.User;
import com.study.jpaSpecification.resource.request.UserRequest;

import java.util.List;

public interface UserService {

    User save(User user);

    List<User> findAll(final String secondName);
}
