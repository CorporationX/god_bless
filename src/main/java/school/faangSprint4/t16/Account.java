package school.faangSprint4.t16;

import lombok.Getter;

import java.util.concurrent.locks.ReentrantLock;

@Getter
public class Account {
    private final int id;
    private double balance;
    final ReentrantLock lock;

    public Account(int id, double initialBalance) {
        this.id = id;
        this.balance = initialBalance;
        this.lock = new ReentrantLock();
    }

    public void deposit(double amount) {
        lock.lock();
        try {
            balance += amount;
        } finally {
            lock.unlock();
        }
    }

    public boolean withdraw(double amount) {
        lock.lock();
        try {
            if (balance >= amount) {
                balance -= amount;
                return true;
            }
            return false;
        } finally {
            lock.unlock();
        }
    }
}