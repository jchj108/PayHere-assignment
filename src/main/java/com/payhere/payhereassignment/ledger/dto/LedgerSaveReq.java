package com.payhere.payhereassignment.ledger.dto;

import com.payhere.payhereassignment.ledger.domain.Ledger;
import com.payhere.payhereassignment.user.domain.User;

import java.time.LocalDateTime;

public class LedgerSaveReq {

    private LocalDateTime writedTime;
    private String memo;
    private Long amount;
    private User user;

    public LedgerSaveReq(LocalDateTime writedTime, String memo, Long amount, User user) {
        this.writedTime = writedTime;
        this.memo = memo;
        this.amount = amount;
        this.user = user;
    }

    public Ledger toEntity() {
        return Ledger.builder()
                .writedTime(this.writedTime)
                .memo(this.memo)
                .amount(this.amount)
                .user(this.user)
                .build();
    }
}
