package com.study.jpaSpecification.service.impl;

import com.study.jpaSpecification.domain.User;
import com.study.jpaSpecification.repository.UserRepository;
import com.study.jpaSpecification.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> findAll(Specification<User> userSpecification) {
        return userRepository.findAll(userSpecification);
    }
}
