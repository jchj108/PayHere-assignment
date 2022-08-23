package com.payhere.payhereassignment.ledger.dto;

import com.payhere.payhereassignment.ledger.domain.Ledger;
import com.payhere.payhereassignment.user.domain.User;

import java.time.LocalDateTime;

public class LedgerRes {

    private Long id;
    private LocalDateTime writedTime;
    private String memo;
    private Long amount;
    private User user;

    public LedgerRes(Ledger ledger) {
        this.id = ledger.getId();
        this.writedTime = ledger.getWritedTime();
        this.memo = ledger.getMemo();
        this.amount = ledger.getAmount();
        this.user = ledger.getUser();
    }
}
