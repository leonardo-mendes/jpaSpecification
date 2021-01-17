package com.study.jpaSpecification.resource.request;

import com.study.jpaSpecification.domain.User;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class UserRequest implements Serializable {

    private String firstName;

    private String secondName;

    private Integer age;

    public User buildDomain(){
        return User.builder()
                .firstName(this.firstName)
                .secondName(this.secondName)
                .age(this.age)
                .build();
    }
}
