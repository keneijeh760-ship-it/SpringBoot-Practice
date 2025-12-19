package com.phope.hope.DTO;

public class AccountRequestDTO {

    private long accountNumber;
    private double balance;

    public AccountRequestDTO(){}

    public String getAccountNumber(){
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
