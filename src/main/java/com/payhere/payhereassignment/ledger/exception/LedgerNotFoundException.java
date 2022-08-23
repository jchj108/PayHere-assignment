package com.payhere.payhereassignment.ledger.exception;

public class LedgerNotFoundException extends Exception {

    public LedgerNotFoundException() {
        super("가계부가 존재하지 않습니다");
    }

    public LedgerNotFoundException(String message) {
        super(message);
    }

    public LedgerNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public LedgerNotFoundException(Throwable cause) {
        super(cause);
    }
}
