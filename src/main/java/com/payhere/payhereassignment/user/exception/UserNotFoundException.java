package com.payhere.payhereassignment.user.exception;

public class UserNotFoundException extends Exception {

    public UserNotFoundException() {
        super("유저가 존재하지 않습니다");
    }

    public UserNotFoundException(String message) {
        super(message);
    }

    public UserNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserNotFoundException(Throwable cause) {
        super(cause);
    }
}
