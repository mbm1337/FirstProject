import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Bank bank = new Bank(3);
        Bank.getTotalBanks();
        TextUI ui = new TextUI();

        int count = 0;

        FileIO fileIO = new FileIO();
        ArrayList<String> data = fileIO.readFileData("src/data.csv");

        if(data.size() > 0) {

            for (String s : data) {
                String[] line = s.split(",");
                String name = line[0];
                int balance = Integer.parseInt(line[1].trim());
                Customer c = bank.registerCustomer(name);
                c.receiveAmount(balance);
            }
        }else{
                while (count < bank.customerLimit) {
                    String name = ui.getInput("Skriv kundens navn: ");
                    Customer c = bank.registerCustomer(name);
                    c.receiveAmount(30000);
                    count++;
                }
            }

        Customer c =bank.getCustomer(0);
        bank.displayCustomers();
        c.receiveAmount(100000);
        bank.displayCustomers();

        fileIO.saveData("src/data.csv", bank.getCustomers());

    }
}
