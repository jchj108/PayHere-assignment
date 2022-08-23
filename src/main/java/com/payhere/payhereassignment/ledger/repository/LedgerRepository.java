package com.payhere.payhereassignment.ledger.repository;


import com.payhere.payhereassignment.ledger.domain.Ledger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Transactional
public interface LedgerRepository extends JpaRepository<Ledger, Long> {

    Optional<List<Ledger>> findByUserId(String userId);

    @Modifying
    @Query(value = "update ledger set deleted = false where id = :id", nativeQuery = true)
    void restore(@Param("id")Long id) throws Exception;

    @Query(value = "select * from ledger l where date(l.writedTime) = date(:date)", nativeQuery = true)
    List<Ledger> findByDate(@Param("date") LocalDateTime date);
}
