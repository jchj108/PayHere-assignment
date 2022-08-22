package com.payhere.payhereassignment.ledger.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.time.LocalDateTime;

@Builder
@Entity
@Getter
@NoArgsConstructor
@SQLDelete(sql = "UPDATE ledger set deleted = true WHERE id = ?") // Delete시 해당 구문으로 SoftDelete
@Where(clause = "deleted = false") // 삭제되지 않은 데이터만 삭제해야 하므로 SQL Delete에 조건을 추가된다
public class ledger {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private LocalDateTime writedTime;
    @Column
    private String memo;
    @Column
    private Long amount;
    @Column
    private boolean deleted = Boolean.FALSE;

    public ledger(Long id, LocalDateTime writedTime, String memo, Long amount, boolean deleted) {
        this.id = id;
        this.writedTime = writedTime;
        this.memo = memo;
        this.amount = amount;
        this.deleted = deleted;
    }
}


