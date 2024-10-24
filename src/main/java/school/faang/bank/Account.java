package school.faang.bank;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@AllArgsConstructor
@Getter
public class Account {
    private int id;
    private double balance;
    private final Lock lock = new ReentrantLock();

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

    public double getBalance() {
        lock.lock();
        try {
            return balance;
        } finally {
            lock.unlock();
        }
    }
}
