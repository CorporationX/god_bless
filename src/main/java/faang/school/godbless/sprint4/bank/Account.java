package faang.school.godbless.sprint4.bank;

import lombok.Data;

import java.util.concurrent.locks.ReentrantLock;

@Data
public class Account {
    private int id;
    private int balance;
    private final ReentrantLock lock = new ReentrantLock();

    public Account(int id, int balance) {
        this.id = id;
        this.balance = balance;
    }

    public void deposit(int amount) {
        lock.lock();
        try {
            balance += amount;
        }finally {
            lock.unlock();
        }
    }
    public void withdraw(int amount) {
        lock.lock();
        try {
            balance -= amount;
        }finally {
            lock.unlock();
        }
    }
}
