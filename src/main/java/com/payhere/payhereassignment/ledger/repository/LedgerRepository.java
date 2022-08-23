package com.payhere.payhereassignment.ledger.repository;


import com.payhere.payhereassignment.ledger.domain.Ledger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LedgerRepository extends JpaRepository<Ledger, String> {

}
