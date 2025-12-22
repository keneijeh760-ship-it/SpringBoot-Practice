package com.phope.hope.exception;

public class InsufficinetFundsException extends RuntimeException{
    public InsufficinetFundsException() {
        super("Insufficient Funds");
    }
}
