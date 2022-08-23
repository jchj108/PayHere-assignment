package com.payhere.payhereassignment.ledger.dto;

import com.payhere.payhereassignment.ledger.domain.Ledger;
import com.payhere.payhereassignment.user.domain.User;
import lombok.Getter;

import javax.validation.constraints.NotNull;

@Getter
public class LedgerSelectByUserIdReq {
    @NotNull
    private String userId;

    public LedgerSelectByUserIdReq(String userId) {
        this.userId = userId;

    }

    public Ledger toEntity() {
        return Ledger.builder()
                .user(User.builder().id(this.userId).build())
                .build();
    }
}
