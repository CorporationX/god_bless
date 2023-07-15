package faang.school.godbless.letsPlayBank;

import lombok.Getter;

import java.util.concurrent.locks.ReentrantLock;

@Getter
public class Account {
    private final int id;
    private double balance;
    private final ReentrantLock lock;

    public Account(int id, double balance) {
        this.id = id;
        this.balance = balance;
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

    public void withdraw(double amount) {
        lock.lock();
        try {
            balance -= amount;
        } finally {
            lock.unlock();
        }
    }

}
