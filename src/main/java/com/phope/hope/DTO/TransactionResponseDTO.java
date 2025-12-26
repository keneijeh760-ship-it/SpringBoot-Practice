package com.phope.hope.DTO;

import com.phope.hope.Entity.Status;

import java.time.LocalDateTime;

public class TransactionResponseDTO {
    private long id;
    private long fromAccountNumber;
    private long toAccountNumber;
    private double amount;
    private Status status;
    private LocalDateTime timestamp;

    public TransactionResponseDTO(){}

    public long getId() { return id; }
    public long getFromAccountNumber() { return fromAccountNumber; }
    public long getToAccountNumber() { return toAccountNumber; }
    public double getAmount() { return amount; }
    public Status getStatus() { return status; }
    public LocalDateTime getTimestamp() { return timestamp; }

    public void setId(long id) { this.id = id; }
    public void setFromAccountNumber(long fromAccountNumber) { this.fromAccountNumber = fromAccountNumber; }
    public void setToAccountNumber(long toAccountNumber) { this.toAccountNumber = toAccountNumber; }
    public void setAmount(double amount) { this.amount = amount; }
    public void setStatus(Status status) { this.status = status; }
    public void setTimestamp(LocalDateTime timestamp) { this.timestamp = timestamp; }
}
