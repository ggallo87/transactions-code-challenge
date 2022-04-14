package com.mendel.challenge.exception;

public class TransactionException extends RuntimeException{

    private String message;

    public TransactionException(String message){
        super();
        this.message = message;
    }
}
