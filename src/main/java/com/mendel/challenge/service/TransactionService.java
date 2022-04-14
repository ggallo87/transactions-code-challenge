package com.mendel.challenge.service;

import com.mendel.challenge.db.TransactionDb;
import com.mendel.challenge.exception.TransactionException;
import com.mendel.challenge.model.Transaction;
import com.mendel.challenge.request.TransactionRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class TransactionService {

    private final static Logger LOGGER = LoggerFactory.getLogger(TransactionService.class);
    private TransactionDb db = TransactionDb.getInstance();


    public void putTransaction(TransactionRequest data, long transactionId){
        Transaction transaction = new Transaction();
        transaction.setId(transactionId);
        transaction.setType(data.getType());
        transaction.setParent_id(data.getParent_id());
        transaction.setAmount(data.getAmount());

        LOGGER.info("[TRANSACTION_SERVICE][ADD_TRANSACTION]");
        try {
            db.addTransaction(transaction);
        } catch (Exception e) {
            LOGGER.error("[TRANSACTION_SERVICE][PUT_TRANSACTION] Error in put transaction ", e.getMessage());
            throw new TransactionException(e.getStackTrace().toString());
        }
    }

    public List<Long> getByType(String type) {
        List<Transaction> list = db.getTransactionByType(type);
        List<Long> ids = new ArrayList<>();
        list.forEach((t) -> {
           ids.add(t.getId());
        });
        return ids;
    }
}
