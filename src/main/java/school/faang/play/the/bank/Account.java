package school.faang.play.the.bank;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

@Getter
@AllArgsConstructor
public class Account {
    private int id;

    @Getter(AccessLevel.NONE)
    private double balance;

    @Getter(AccessLevel.NONE)
    private final ReadWriteLock rwLock = new ReentrantReadWriteLock();

    private final Object lock = new Object();

    public void deposit(double amount) {
        rwLock.writeLock().lock();
        try{
            balance += amount;
        } finally {
            rwLock.writeLock().unlock();
        }
    }

    public synchronized void withdraw(double amount) {
        rwLock.writeLock().lock();
        try{
            balance -= amount;
        } finally {
            rwLock.writeLock().unlock();
        }
    }

    public double getBalance() {
        rwLock.readLock().lock();
        try{
            return balance;
        } finally {
            rwLock.readLock().unlock();
        }
    }

    @Override
    public String toString() {
        return id + ": " + balance;
    }
}
