package com.payhere.payhereassignment.ledger.exception;

public class LedgerNotFoundException extends Exception {

    public LedgerNotFoundException() {
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
