package com.payhere.payhereassignment.ledger.controller;

import com.payhere.payhereassignment.common.dto.SimpleResponseDto;
import com.payhere.payhereassignment.ledger.dto.LedgerDeleteReq;
import com.payhere.payhereassignment.ledger.dto.LedgerRes;
import com.payhere.payhereassignment.ledger.dto.LedgerSaveReq;
import com.payhere.payhereassignment.ledger.repository.LedgerRepository;
import com.payhere.payhereassignment.ledger.service.LedgerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class LedgerController {

    private final LedgerRepository ledgerRepository;
    private final LedgerService ledgerService;

    @PostMapping(path = "/ledger")
    public ResponseEntity<LedgerRes> saveOne(@Validated LedgerSaveReq ledgerSaveReq) throws Exception {
        return ledgerService.saveOne(ledgerSaveReq);
    }

    @DeleteMapping(path = "/ledger/{id}")
    public ResponseEntity<SimpleResponseDto> deleteOne(@Validated LedgerDeleteReq LedgerDeleteReq) throws Exception {
        return ledgerService.deleteOne(LedgerDeleteReq);
    }
}
