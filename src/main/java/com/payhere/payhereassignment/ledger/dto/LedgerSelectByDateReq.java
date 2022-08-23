package com.payhere.payhereassignment.ledger.dto;

import com.payhere.payhereassignment.ledger.domain.Ledger;
import lombok.Getter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
public class LedgerSelectByDateReq {
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    @NotNull
    private LocalDateTime writedTime;


    public LedgerSelectByDateReq(LocalDateTime writedTime) {
        this.writedTime = writedTime;
    }

    public Ledger toEntity() {
        return Ledger.builder()
                .build();
    }
}
