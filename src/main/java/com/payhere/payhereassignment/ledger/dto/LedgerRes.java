package com.payhere.payhereassignment.ledger.dto;

import com.payhere.payhereassignment.ledger.domain.Ledger;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class LedgerRes {

    private Long id;
    private LocalDateTime writedTime;
    private String memo;
    private Long amount;
    private String userId;

    public LedgerRes(Ledger ledger) {
        this.id = ledger.getId();
        this.writedTime = ledger.getWritedTime();
        this.memo = ledger.getMemo();
        this.amount = ledger.getAmount();
        this.userId = ledger.getUser().getId();
    }
}
