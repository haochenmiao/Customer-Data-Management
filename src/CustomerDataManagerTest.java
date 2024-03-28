import java.io.File;
import java.io.IOException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CustomerDataManagerTest {
    private CustomerDataManager customerDataManager;
    private File customersFile = new File("Customers.txt");
    private File csvFile = new File("customers.csv");

    @BeforeEach
    public void setUp() throws IOException {
        customerDataManager = new CustomerDataManager(customersFile);
    }

    @AfterEach
    public void tearDown() throws Exception {
        customerDataManager = null;
        csvFile.delete();
    }

    @Test
    public void findCustomer() {
        Customer expectedCustomer = new Customer("24331", "Derk", "Bienvenu", "dbienvenu8v@rediff.com", 9096.75);
        Customer actualCustomer = customerDataManager.findCustomer("Bienvenu", "24331");
        assertEquals(expectedCustomer.toString(), actualCustomer.toString());
    }

    @Test
    public void getCustomerCountTest() {
        int expectedCount = 1000;
        int actualCount = customerDataManager.getCustomerCount();
        assertEquals(expectedCount, actualCount);
    }

    @Test
    public void generateCsvTest() throws IOException {
        int expectedCount = customerDataManager.getCustomerCount();
        boolean wantHeader = true;
        int actualCount = customerDataManager.generateCsv(csvFile, wantHeader);
        assertEquals(expectedCount,actualCount, "Expected and actual customer count should match.");

        // Check if the file has been created
        assertTrue(csvFile.exists(), "The file should be generated");
    }
}
