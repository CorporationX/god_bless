package bank.game;

import lombok.Getter;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Getter
public class Account {
    private static final double DEFAULT_BALANCE = 500.0;
    private static final AtomicInteger idCount = new AtomicInteger(0);

    private final int id = idCount.getAndIncrement();
    private double balance = DEFAULT_BALANCE;
    private final Lock lock = new ReentrantLock();

    public void deposit(double amountToDeposit) {
        lock.lock();
        balance += amountToDeposit;
        lock.unlock();
    }

    public void withdraw(double amountToWithdraw) {
        lock.lock();
        balance -= amountToWithdraw;
        lock.unlock();
    }
}
