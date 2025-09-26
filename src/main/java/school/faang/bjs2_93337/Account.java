package school.faang.bjs2_93337;

import lombok.Getter;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Getter
public class Account {
    private int id;
    private double balance;
    private Lock lock = new ReentrantLock();

    public Account(int id, double balance) {
        this.id = id;
        this.balance = balance;
    }

    public void deposit(double amount) {
        lock.lock();
        try {
            balance = getBalance() + amount;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        lock.unlock();
    }

    public void withdraw(double amount) {
        lock.lock();
        try {
            balance = getBalance() - amount;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        lock.unlock();
    }
}
