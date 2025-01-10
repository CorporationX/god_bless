package school.faang.bjs251105;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Getter
@AllArgsConstructor
@RequiredArgsConstructor
public class Account {
    private final int id;
    private double balance;

    private final Lock lock = new ReentrantLock();

    public void deposit(double amount) {
        try {
            lock.lock();
            if (amount > 0) {
                balance += amount;
            } else {
                throw new IllegalArgumentException("Invalid deposit amount");
            }
        } finally {
            lock.unlock();
        }
    }

    public void withdraw(double amount) {
        try {
            lock.lock();
            if (amount > 0 && amount <= balance) {
                balance -= amount;
            } else {
                throw new IllegalArgumentException("Invalid withdrawal amount");
            }
        } finally {
            lock.unlock();
        }
    }
}