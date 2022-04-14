import com.mendel.challenge.db.TransactionDb;
import com.mendel.challenge.model.Transaction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TransactionTest {

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
        Transaction response = tdb.getTransaction(transaction.getId() + "-" + transaction.getType());
        assertNotNull(response);
        assertEquals("test", response.getType());

    }

}
