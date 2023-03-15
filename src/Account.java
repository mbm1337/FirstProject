public class Account {

    private int balance;

    public Account() {

    }

    public int getBalance() {

        return balance;
    }

    public void setBalance(int amount) {

    }

    public void updateBalance(int amount){
        this.balance += amount;
    }

}