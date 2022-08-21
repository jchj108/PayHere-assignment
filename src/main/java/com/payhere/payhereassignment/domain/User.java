package com.payhere.payhereassignment.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Collection;

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
}
