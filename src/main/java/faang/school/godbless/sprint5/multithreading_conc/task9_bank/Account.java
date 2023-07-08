package faang.school.godbless.sprint5.multithreading_conc.task9_bank;

import lombok.Getter;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class Account {

    @Getter
    private final int id;

    private AtomicInteger balance;

    @Getter
    private ReentrantLock lock;

    public Account(int id, int balance) {
        this.id = id;
        this.balance = new AtomicInteger(balance);
        lock = new ReentrantLock();
    }

    public void deposit(int amount) {
        lock.lock();
        try {
            balance.getAndAdd(amount);
        } finally {
            lock.unlock();
        }
    }

    public void withdraw(int amount) {
        lock.lock();
        try {
            balance.getAndAdd(-amount);
        } finally {
            lock.unlock();
        }
    }

    public AtomicInteger getBalance() {
        lock.lock();
        try {
            return balance;
        } finally {
            lock.unlock();
        }
    }
}
