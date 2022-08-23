package com.payhere.payhereassignment.user.dto;

import com.payhere.payhereassignment.user.domain.User;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Getter
@ToString
public class UserSignUpReq {

    @NotEmpty
    @Email
    private String id;

    @NotEmpty
    private String password;

    @Builder
    public UserSignUpReq(String email, String password) {
        this.id = email;
        this.password = password;
    }

    public User toEntity() {
        return User.builder()
                .id(this.getId())
                .password(this.getPassword())
                .build();
    }
}
