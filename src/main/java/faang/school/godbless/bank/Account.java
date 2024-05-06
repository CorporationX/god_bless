package faang.school.godbless.bank;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.concurrent.locks.ReentrantLock;

@AllArgsConstructor
public class Account {
    @Getter
    private int id;
    private int balance;
    private final ReentrantLock lock = new ReentrantLock();

    public void deposit(int value) {
        lock.lock();
        try {
            balance += value;
        } finally {
            lock.unlock();
        }
    }

    public void withdraw(int value) {
        lock.lock();
        try {
            balance -= value;
        } finally {
            lock.unlock();
        }
    }

    public int getBalance() {
        lock.lock();
        try {
            return balance;
        } finally {
            lock.unlock();
        }
    }
}
