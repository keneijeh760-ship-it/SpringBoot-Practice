package com.phope.hope.exception;

public class AccountNotFoundException extends RuntimeException{
    public AccountNotFoundException(Long id) {
        super("Account Not Found with ID: " + id);
    }
}
