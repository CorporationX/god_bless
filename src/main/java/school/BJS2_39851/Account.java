package school.BJS2_39851;

import lombok.Getter;

public class Account {

    private int id;
    @Getter
    private double balance;
    private final Object lock = new Object();

    public Account(int id, double balance) {
        this.id = id;
        this.balance = balance;
    }

    public void deposit(double amount) {
        synchronized (lock) {
            balance += amount;
        }
    }
    public void withdraw(double amount) {
        synchronized (lock) {
            balance -= amount;
        }
    }

}
