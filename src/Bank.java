import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Bank {
    public int customerLimit;
    private ArrayList<Customer> customers = new ArrayList<>();

    public Bank(int customerLimit) {
        this.customerLimit = customerLimit;

    }
    public static int getTotalBanks() {
        return 1;
    }
    public Customer registerCustomer(String name) {
        Customer c = new Customer(name);
        customers.add(c);
        return c;
    }
    public void displayCustomers() {
        for (Customer c : customers) {
            System.out.println(c);
        }
    }
    public void saveCustomers() {
        File file = new File("bankaccounts.txt");
        try {
            FileWriter writer = new FileWriter(file);
            for (Customer c : customers) {
                writer.write(c.getName() + ": " + c.getAccount().getBalance() + "\n");
            }
            writer.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public Customer getCustomer(int i) {
        return customers.get(i);
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

}
