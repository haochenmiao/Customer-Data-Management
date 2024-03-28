import java.io.File;
import java.io.FileNotFoundException;

public class Main {
    public static void main (String[] args) throws FileNotFoundException {
        CustomerDataManager dataManager = new CustomerDataManager(new File("Customers.txt"));
        Customer customer = dataManager.findCustomer("Abreheart","22315");
        if (customer != null) {
            System.out.println("Successful customer search: " + customer.toString());
        } else {
            System.out.println("Unsuccessful customer search: ");
        }
        System.out.println("The number of customers: "+ dataManager.getCustomerCount());

        File csvFile = new File("customers.csv");
        int customersPrint = dataManager.generateCsv(csvFile, true);
        if (customersPrint != -1) {
            System.out.println("CSV file generated successfully with: "+
                    customersPrint + " customers written.");
            System.out.println("File name: " + csvFile.getName());
        } else {
            System.out.println("error generating CSV file. ");
        }
    }
}
