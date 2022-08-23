package com.payhere.payhereassignment.ledger.service;

import com.payhere.payhereassignment.common.dto.SimpleResponseDto;
import com.payhere.payhereassignment.ledger.domain.Ledger;
import com.payhere.payhereassignment.ledger.dto.LedgerDeleteReq;
import com.payhere.payhereassignment.ledger.dto.LedgerRes;
import com.payhere.payhereassignment.ledger.dto.LedgerSaveReq;
import com.payhere.payhereassignment.ledger.repository.LedgerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LedgerService {
    private final LedgerRepository ledgerRepository;

    public ResponseEntity<LedgerRes> saveOne(LedgerSaveReq ledgerSaveReq) {
        Ledger ledger = ledgerRepository.save(ledgerSaveReq.toEntity());
        return ResponseEntity.ok(new LedgerRes(ledger));
    }

    public ResponseEntity<SimpleResponseDto> deleteOne(LedgerDeleteReq ledgerDeleteReq) {
        ledgerRepository.delete(ledgerDeleteReq.toEntity());
        return ResponseEntity.ok(new SimpleResponseDto(true));
    }

}
