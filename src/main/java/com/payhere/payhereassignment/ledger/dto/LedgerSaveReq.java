package com.payhere.payhereassignment.ledger.dto;

import com.payhere.payhereassignment.ledger.domain.Ledger;
import com.payhere.payhereassignment.user.domain.User;
import lombok.Getter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
public class LedgerSaveReq {
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime writedTime;
    private String memo;
    private Long amount;
    @NotNull
    private String userId;

    public LedgerSaveReq(LocalDateTime writedTime, String memo, Long amount, String userId) {
        this.writedTime = writedTime;
        this.memo = memo;
        this.amount = amount;
        this.userId = userId;
    }

    public Ledger toEntity() {
        return Ledger.builder()
                .writedTime(this.writedTime)
                .memo(this.memo)
                .amount(this.amount)
                .user(User.builder().id(this.userId).build())
                .build();
    }
}
