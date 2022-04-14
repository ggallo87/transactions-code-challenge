package com.mendel.challenge.db;

import com.mendel.challenge.model.Transaction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TransactionDBTest {

    private final TransactionDb tdb = TransactionDb.getInstance();
    private Transaction transaction;

    @BeforeEach
    public void setUp() {
        transaction = new Transaction();
        transaction.setId(1L);
        transaction.setType("test");
        transaction.setAmount(1000);
    }

    @Test
    public void testGetInstance() {
        assertNotNull(tdb);
    }

    @Test
    public void testAddTransactionToDB() throws Exception {
       assertDoesNotThrow(() -> tdb.addTransaction(transaction));
    }

    @Test
    public void testGetTransactionFromDB(){
        Transaction response = tdb.getTransaction(transaction.getId().toString());
        assertNotNull(response);
        assertEquals("test", response.getType());
    }

    @Test
    public void testGetTransactionByType(){
        List<Transaction> list = tdb.getTransactionByType("test");
        assertNotNull(list);
        assertEquals(1, list.size());
        assertEquals(1000, list.get(0).getAmount());
    }

}
