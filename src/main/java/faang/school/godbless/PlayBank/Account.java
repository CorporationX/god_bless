package faang.school.godbless.PlayBank;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.concurrent.locks.ReentrantLock;
@Data
@AllArgsConstructor
public class Account {
    private int id;
    private double balance;
    private ReentrantLock lock;

    public Account(int id, double balance) {
        this.id = id;
        this.balance = balance;
        this.lock = new ReentrantLock();
    }

    public void deposit(int amount) {
        lock.lock();
        try {
            balance += amount;
        } finally {
            lock.unlock();
        }
    }

    public void withdraw(int amount) {
        lock.lock();
        try {
            balance -= amount;
        } finally {
            lock.unlock();
        }
    }
}
