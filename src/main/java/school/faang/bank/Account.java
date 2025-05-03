package school.faang.bank;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.concurrent.locks.ReentrantLock;

@AllArgsConstructor
@Getter
public class Account {
    private final int id;
    private double balance;
    private final ReentrantLock lock = new ReentrantLock();
    private static final int TIME_SLEEP = 1000;

    public void deposit(double amount) {
        lock.lock();
        try {
            Thread.sleep(TIME_SLEEP);
            balance += amount;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }

    public boolean withdraw(double amount) {
        lock.lock();
        try {
            if (balance > amount) {
                Thread.sleep(TIME_SLEEP);
                balance -= amount;
                return true;
            } else {
                System.out.println("На счету не достаточно средств " + balance);
                return false;
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
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

