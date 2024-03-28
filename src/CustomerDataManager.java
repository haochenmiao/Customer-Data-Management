import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;
import java.util.LinkedList;

/**
 * This class manages the functions of the data file of customers info
 * @author      Haochen Miao
 * @version     2/14/2023
 */
public class CustomerDataManager implements CustomerDataManagerInterface {

    /**
     * This Linked list stores the letters that represents letter group
     * the list represents
     */
    private LinkedList<TaggedLinkedList<Customer>> customerBuckets = new LinkedList<>();

    /**
     * This linked list stores the data from the file of customers info
     */
    private LinkedList<Customer> customerList = new LinkedList<>();

    /**
     * it reads through the data file and store it in the linked list
     * @param customerFile      the file of customers info data
     * @throws FileNotFoundException        if the file is not found
     */
    public CustomerDataManager (File customerFile) throws FileNotFoundException {
        for (char letter = 'A'; letter <= 'Z'; letter++) {
            customerBuckets.add(new TaggedLinkedList<Customer>(letter));
            //make sure to have all the alphabet here.
        }

        try (Scanner fileScanner = new Scanner(customerFile)) {
            fileScanner.nextLine();

            while (fileScanner.hasNextLine()) {
                String[] customerData = fileScanner.nextLine().split(",");
                Customer customer = new Customer(customerData[0], customerData[2],
                        customerData[1], customerData[3], Double.parseDouble(customerData[4]));
                int bucketIndex = Character.toLowerCase(customer.lastName().charAt(0)) - 'a'; //retrieving a character
                customerBuckets.get(bucketIndex).add(customer);
                customerList.add(customer);
            }
        } catch (FileNotFoundException e) {
            System.out.println("The file could not found: " + e.getMessage());
        }
    }

    /**
     * Retrieves the count of customers in the customer list
     *
     * @return count of customers
     */
    @Override
    public int getCustomerCount() {
        return customerList.size();
    }

    /**
     * Retrieves the customer with the specified id, in the bucket determined by last name
     *
     * @param lastName used for its first character; the lower-cased letter is used to determine bucket
     * @param id       the customer id to look up
     * @return the corresponding customer, or null if the customer isn't found
     */
    @Override
    public Customer findCustomer(String lastName, String id) {
        int bucketIndex = Character.toUpperCase(lastName.charAt(0)) - 'A'; //retreive a character, upper case
        for (Customer customer : customerBuckets.get(bucketIndex))
            if (customer.id().equals(id)) {
                return customer;
            }
        return null;
    }

    /**
     * Generates a CSV file containing all customers, in bucket order
     *
     * @param csvFile    a File reference to the output file to create
     * @param wantHeader whether a header line should be at the top of the file
     * @return the count of customers written to the file; -1 if there was an error creating the file
     */
    @Override
    public int generateCsv(File csvFile, boolean wantHeader) {

        try (PrintStream writer = new PrintStream(csvFile)) {
            if (wantHeader) {
                writer.println("id,lastName,firstName,email,balance");
            }

            int customerCount = 0;
            for (char c = 'A'; c <= 'Z'; c++) {
                TaggedLinkedList<Customer> bucket = customerBuckets.get(c - 'A'); // need to have a character, that character needs to be upper case
                for (Customer customer : bucket) {
                    writer.println(String.format("%s,%s,%s,%s,%.2f", customer.id(),
                            customer.lastName(), customer.firstName(), customer.email(),
                            customer.balance()));
                    customerCount++;
                }
            }
            writer.close();
            return customerCount;
        } catch (FileNotFoundException e) {
            return -1;
        }
    }
}
