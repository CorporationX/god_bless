package bank.game;

import lombok.Getter;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Account {
    private static final double DEFAULT_BALANCE = 500.0;
    private static final AtomicInteger idCount = new AtomicInteger(0);

    @Getter
    private final int id = idCount.getAndIncrement();
    private double balance = DEFAULT_BALANCE;
    private final Lock lock = new ReentrantLock();

    public void deposit(double amountToDeposit) {
        lock.lock();
        try {
            balance += amountToDeposit;
        } finally {
            lock.unlock();
        }
    }

    public void withdraw(double amountToWithdraw) {
        lock.lock();
        try {
            balance -= amountToWithdraw;
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
