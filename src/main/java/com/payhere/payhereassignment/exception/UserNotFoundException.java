package com.payhere.payhereassignment.exception;

public class UserNotFoundException extends Exception {

    public UserNotFoundException() {
        super("Can't find User");
    }

}
