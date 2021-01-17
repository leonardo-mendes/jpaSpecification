package com.study.jpaSpecification.service.impl;

import com.study.jpaSpecification.domain.User;
import com.study.jpaSpecification.repository.UserRepository;
import com.study.jpaSpecification.repository.specification.SearchCriteria;
import com.study.jpaSpecification.repository.specification.UserSpecification;
import com.study.jpaSpecification.service.UserService;
import lombok.RequiredArgsConstructor;
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
    public List<User> findAll(String secondName) {
        UserSpecification userSpecification = new UserSpecification(new SearchCriteria("secondName",":", secondName));
        return userRepository.findAll(userSpecification);
    }
}
