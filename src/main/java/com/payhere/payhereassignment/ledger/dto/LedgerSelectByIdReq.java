package com.payhere.payhereassignment.ledger.dto;

import com.payhere.payhereassignment.ledger.domain.Ledger;
import lombok.Getter;

import javax.validation.constraints.NotNull;

@Getter
public class LedgerSelectByIdReq {
    @NotNull
    private Long id;

    public LedgerSelectByIdReq(Long id) {
        this.id = id;

    }

    public Ledger toEntity() {
        return Ledger.builder()
                .id(this.id)
                .build();
    }
}
