package com.payhere.payhereassignment.user.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Builder
@Entity
@Getter
@NoArgsConstructor
public class User {
    @Id
    private String email;
    @Column
    private String password;

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public User hashPassword(PasswordEncoder passwordEncoder) {
        this.password = passwordEncoder.encode(this.password);
        return this;
    }
}
