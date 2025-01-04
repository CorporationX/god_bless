package school.faang.task51199bank;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.concurrent.locks.ReentrantLock;

@Getter
@AllArgsConstructor
public class Account {
    private final int id;
    private double balance;
    private final ReentrantLock lock = new ReentrantLock();

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

    public double getBalance() {
        lock.lock();
        try {
            return balance;
        } finally {
            lock.unlock();
        }
    }
}
