package com.study.jpaSpecification.resource;

import com.study.jpaSpecification.domain.User;
import com.study.jpaSpecification.resource.request.UserRequest;
import com.study.jpaSpecification.service.UserService;
import lombok.RequiredArgsConstructor;
import net.kaczmarzyk.spring.data.jpa.domain.Equal;
import net.kaczmarzyk.spring.data.jpa.domain.Like;
import net.kaczmarzyk.spring.data.jpa.web.annotation.And;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping(value = "/users")
@RequiredArgsConstructor
public class UserResource {

    private final UserService userService;

    @PostMapping
    @ResponseStatus(code = CREATED)
    User insert(@RequestBody UserRequest userRequest) {
        return userService.save(userRequest.buildDomain());
    }

    @GetMapping
    List<User> findAll(
            @And({
                    @Spec(path = "firstName", spec = Like.class),
                    @Spec(path = "secondName", spec = Like.class),
                    @Spec(path = "age", spec = Equal.class)})
                    Specification<User> userSpecification
    ) {
        return userService.findAll(userSpecification);
    }
}
