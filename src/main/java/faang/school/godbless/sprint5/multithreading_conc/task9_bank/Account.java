package faang.school.godbless.sprint5.multithreading_conc.task9_bank;

import lombok.Getter;

import java.util.concurrent.locks.ReentrantLock;

@Getter
public class Account {

    private final int id;

    private int balance;

    private ReentrantLock lock;

    public Account(int id, int balance) {
        this.id = id;
        this.balance = balance;
        lock = new ReentrantLock();
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
