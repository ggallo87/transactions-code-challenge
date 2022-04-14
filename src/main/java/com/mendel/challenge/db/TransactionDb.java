package com.mendel.challenge.db;

import com.mendel.challenge.model.Transaction;

import java.util.HashMap;
import java.util.Map;

public class TransactionDb {

    private static TransactionDb instance;
    private static Map<String,Transaction> transactionList;

    private TransactionDb(){
    }

    public static TransactionDb getInstance() {
        if (instance == null) {
            instance = new TransactionDb();
            transactionList = new HashMap<>();
        }
        return instance;
    }

    public void addTransaction(Transaction t) throws Exception{
        transactionList.put(t.getId() + "-" + t.getType(), t);
    }

    public Transaction getTransaction(String key) {
        return transactionList.get(key);
    }


}
