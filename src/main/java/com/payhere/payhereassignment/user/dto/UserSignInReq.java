package com.payhere.payhereassignment.user.dto;

import com.payhere.payhereassignment.user.domain.User;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Getter
@ToString
public class UserSignInReq {

    @NotEmpty
    @Email
    private String email;

    @NotEmpty
    private String password;

    @Builder
    public UserSignInReq(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public User toEntity() {
        return User.builder()
                .email(this.getEmail())
                .password(this.getPassword())
                .build();
    }
}
