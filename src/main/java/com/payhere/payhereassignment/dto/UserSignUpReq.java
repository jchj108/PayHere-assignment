package com.payhere.payhereassignment.dto;

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
    private String email;

    @NotEmpty
    private String password;

    @Builder
    public UserSignUpReq(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public UserSignUpReq toEntity() {
        return UserSignUpReq.builder()
                .email(this.getEmail())
                .password(this.getPassword())
                .build();
    }
}
