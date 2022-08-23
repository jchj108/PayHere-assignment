package com.payhere.payhereassignment.user.domain;

import com.payhere.payhereassignment.ledger.domain.Ledger;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Builder
@Entity
@Getter
@NoArgsConstructor
public class User {
    @Id
    private String id;
    @Column
    private String password;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Ledger> ledgerList = new ArrayList<>();

    public User(String email, String password, List<Ledger> ledgerList) {
        this.id = email;
        this.password = password;
        this.ledgerList = ledgerList;
    }

    // 비밀번호 암호화
    public User hashPassword(PasswordEncoder passwordEncoder) {
        this.password = passwordEncoder.encode(this.password);
        return this;
    }
}
