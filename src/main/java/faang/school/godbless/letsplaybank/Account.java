package faang.school.godbless.letsplaybank;

import lombok.Getter;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Account {
    @Getter
    private final int id;
    private double balance;
    @Getter
    private final Lock lock;

    public Account(int id, double balance) {
        this.id = id;
        this.balance = balance;
        this.lock = new ReentrantLock();
    }

    public double getBalance() {
        lock.lock();
        try {
            return balance;
        } finally {
            lock.unlock();
        }
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
            } else {
                return false;
            }
        } finally {
            lock.unlock();
        }
    }
}