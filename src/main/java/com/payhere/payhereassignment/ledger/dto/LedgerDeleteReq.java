package com.payhere.payhereassignment.ledger.dto;

import com.payhere.payhereassignment.ledger.domain.Ledger;
import lombok.Getter;

import javax.validation.constraints.NotNull;

@Getter
public class LedgerDeleteReq {
    @NotNull
    private Long id;


    public LedgerDeleteReq(Long id) {
        this.id = id;
    }

    public Ledger toEntity() {
        return Ledger.builder()
                .id(this.id)
                .build();
    }
}
