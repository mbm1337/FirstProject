public class Customer {
    private int id;
    private String name;
    private Account account;
    private static int counter = 1;

    public Customer(String name) {
        this.name = name;
        this.id = counter;
        this.account = new Account();
        counter++;
    }

    public Account getAccount() {
        return this.account;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }


    public String toString() {
        return getName() + ": " + this.account.getBalance();

    }

    public int receiveAmount(int amount){

        this.account.updateBalance(amount);

        return this.account.getBalance();
    }



}
