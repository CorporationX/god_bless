package faang.school.godbless.concurrency.banking;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantReadWriteLock;

@Slf4j
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class Account {
    int id;
    AtomicInteger balance;
    ReentrantReadWriteLock lock;

    public Account(int id, int balance) {
        this.id = id;
        this.balance = new AtomicInteger(balance);
        lock = new ReentrantReadWriteLock();
    }

    public void deposit(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount cannot be negative or zero!(Account " + id + ")");
        }

        lock.writeLock().lock();

        try {

            balance.addAndGet(amount);
            log.info("New deposit in the amount of " + amount + " to balance of account " + id);
        } finally {
            lock.writeLock().unlock();
        }
    }

    public void withdraw(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdraw amount cannot be negative or zero! (Account " + id + ")");
        }

        lock.writeLock().lock();

        try {
            if (balance.get() < amount) {
                throw new IllegalArgumentException("Withdraw amount cannot be less then balance! (Account " + id + ")");
            }

            balance.addAndGet(-amount);
            log.info("New withdraw in the amount of " + amount + " from balance of account " + id);
        } finally {
            lock.writeLock().unlock();
        }
    }

    public int getBalance() {
        lock.readLock().lock();
        try {
            return balance.get();
        } finally {
            lock.readLock().unlock();
        }
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Account[" +
                "id=" + id +
                ", balance=" + balance +
                ']';
    }
}
