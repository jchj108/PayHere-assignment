package com.payhere.payhereassignment.ledger.controller;

import com.payhere.payhereassignment.common.dto.SimpleResponseDto;
import com.payhere.payhereassignment.ledger.domain.Ledger;
import com.payhere.payhereassignment.ledger.dto.*;
import com.payhere.payhereassignment.ledger.exception.LedgerNotFoundException;
import com.payhere.payhereassignment.ledger.repository.LedgerRepository;
import com.payhere.payhereassignment.ledger.service.LedgerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class LedgerController {
    private final LedgerRepository ledgerRepository;
    private final LedgerService ledgerService;

    @ExceptionHandler(LedgerNotFoundException.class)
    public ResponseEntity<String> ledgerNotFoundExceptionHandler(LedgerNotFoundException exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
    }
    @PostMapping(path = "/ledger")
    public ResponseEntity<LedgerRes> saveOne(@Validated LedgerSaveReq ledgerSaveReq) throws Exception {
        return ledgerService.saveOne(ledgerSaveReq);
    }
    @DeleteMapping(path = "/ledger/{id}")
    public ResponseEntity<SimpleResponseDto> deleteOne(@Validated LedgerDeleteReq LedgerDeleteReq) throws Exception {
        return ledgerService.deleteOne(LedgerDeleteReq);
    }
    @PostMapping(path = "/ledger/restore/{id}")
    public ResponseEntity<SimpleResponseDto> restoreOne(@Validated LedgerRestoreReq ledgerRestoreReq) throws Exception {
        ledgerRepository.restore(ledgerRestoreReq.getId());
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new SimpleResponseDto(true));
    }
    @PostMapping(path = "/ledger/update/{id}")
    public ResponseEntity<SimpleResponseDto> updateOne(@Validated LedgerUpdateReq ledgerUpdateReq) throws Exception {
        ledgerRepository.save(ledgerUpdateReq.toEntity());
        return ResponseEntity.status(HttpStatus.OK).body(
                new SimpleResponseDto(true));
    }
    @GetMapping(path = "/ledger/{id}")
    public ResponseEntity<LedgerRes> findOne(@Validated LedgerSelectByIdReq ledgerSelectByIdReq) throws Exception {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(
                new LedgerRes(ledgerRepository.findById(ledgerSelectByIdReq.getId())
                        .orElseThrow(LedgerNotFoundException::new)
                )
        );
    }
    @GetMapping(path = "/ledger/date/{writedTime}")
    public ResponseEntity<List<LedgerRes>> findByDate(@Validated LedgerSelectByDateReq ledgerSelectByDate) throws Exception {
        List<Ledger> list = ledgerRepository.findByDate(ledgerSelectByDate.getWritedTime());
        List<LedgerRes> body = new ArrayList<LedgerRes>();
        for (Ledger ledger : list) {
            body.add(new LedgerRes(ledger));
        }
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(body);

    }
    @GetMapping(path = "/ledger/list/{userId}")
    public ResponseEntity<List<LedgerRes>> findByUserId(LedgerSelectByUserIdReq ledgerSelectByUserIdReq) throws Exception {
        List<Ledger> list = ledgerRepository.findByUserId(ledgerSelectByUserIdReq.getUserId()).orElseThrow(LedgerNotFoundException::new);
        List<LedgerRes> body = new ArrayList<LedgerRes>();
        for (Ledger ledger : list) {
            body.add(new LedgerRes(ledger));
        }
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(body);
    }
}
