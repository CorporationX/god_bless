package faang.school.godbless.bank;

import lombok.Getter;

public class Account {
    @Getter
    private final int id;
    @Getter
    private volatile int balance;
    private final Object lock = new Object();

    public Account(int id, int balance) {
        this.id = id;
        this.balance = balance;
    }

    public void deposit(int amount) {
        synchronized (lock) {
            this.balance += amount;
        }
    }

    public void withdraw(int amount) {
        synchronized (lock) {
            this.balance -= amount;
        }
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", balance=" + balance +
                '}';
    }
}
