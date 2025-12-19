package com.phope.hope.DTO;

import java.util.List;

public class AccountResponseDTO {
    private long accountNumber;
    private double balance;


    public AccountResponseDTO(){}

    public long getAccountNumber(){
        return accountNumber;
    }

    public double getBalance(){
        return balance;
    }

    public void setAccountNumber(long accountNumber){
        this.accountNumber = accountNumber;
    }

    public void setBalance(double balance){
        this.balance = balance;
    }


}
