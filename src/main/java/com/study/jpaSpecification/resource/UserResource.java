package com.study.jpaSpecification.resource;

import com.study.jpaSpecification.domain.User;
import com.study.jpaSpecification.resource.request.UserRequest;
import com.study.jpaSpecification.service.UserService;
import lombok.RequiredArgsConstructor;
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
            @RequestParam(value = "secondName", required = false) String secondName
    ) {
        return userService.findAll(secondName);
    }
}
