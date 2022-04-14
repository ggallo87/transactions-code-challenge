package com.mendel.challenge.db;

import com.mendel.challenge.model.Transaction;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
        transactionList.put(t.getId().toString(), t);
    }

    public Transaction getTransaction(String key) {
        return transactionList.get(key);
    }

    public List<Transaction> getTransactionByType(String key) {
        return transactionList.values().stream().filter(
                m -> m.getType() == key
        ).collect(Collectors.toList());
    }

    public  List<Transaction> getTransactionIdsToSum(Long key) {
        return transactionList.values().stream().filter(
                m -> m.getParent_id() == key
        ).collect(Collectors.toList());
    }
}
