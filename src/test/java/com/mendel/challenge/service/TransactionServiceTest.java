package com.mendel.challenge.service;

import com.mendel.challenge.request.TransactionRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TransactionServiceTest {

    private TransactionRequest transactionRequest;
    private TransactionService service = new TransactionService();

    @BeforeEach
    public void setUp() {
        transactionRequest = new TransactionRequest();
        transactionRequest.setType("cars");
        transactionRequest.setParent_id(null);
        transactionRequest.setAmount(15000);
    }

    @Test
    public void putTransaction() {
        assertDoesNotThrow(() -> service.putTransaction(transactionRequest, 2L));
    }

    @Test
    public void getByType(){
        service.putTransaction(transactionRequest, 2L);

        transactionRequest = new TransactionRequest();
        transactionRequest.setType("cars");
        transactionRequest.setParent_id(null);
        transactionRequest.setAmount(150000);
        service.putTransaction(transactionRequest, 3L);
        List<Long> l = service.getByType("cars");
        assertNotNull(l);
        assertEquals(2, l.size());
    }
}