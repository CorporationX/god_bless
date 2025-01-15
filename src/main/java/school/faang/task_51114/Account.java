package school.faang.task_51114;

import lombok.Getter;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Getter
public class Account {
    private final int id;
    private final Lock lock = new ReentrantLock();
    private double balance;

    public Account(int id, double initialBalance) {
        this.id = id;
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        lock.lock();
        try {
            balance += amount;
            System.out.println("Deposited " + amount + " to account " + id);
        } finally {
            lock.unlock();
        }
    }

    public boolean withdraw(double amount) {
        lock.lock();
        try {
            if (balance >= amount) {
                balance -= amount;
                System.out.println("Withdrew " + amount + " from account " + id);
                return true;
            } else {
                System.out.println("Insufficient funds in account " + id);
                return false;
            }
        } finally {
            lock.unlock();
        }
    }
}
