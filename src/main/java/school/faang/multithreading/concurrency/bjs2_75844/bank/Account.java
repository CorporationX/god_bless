package school.faang.multithreading.concurrency.bjs2_75844.bank;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.UUID;
import java.util.concurrent.locks.ReentrantLock;

@Slf4j
@Getter
public class Account {
    private final UUID id;
    private double balance;
    private final ReentrantLock lock = new ReentrantLock();

    public Account(double balance) {
        this.id = UUID.randomUUID();
        this.balance = balance;
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
            if (balance < amount) {
                log.warn("Insufficient funds to withdraw");
                return false;
            } else {
                balance -= amount;
                return true;
            }
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

    @Override
    public String toString() {
        return String.format("Account(id=%s, balance=%.2f)", id, balance);
    }
}
