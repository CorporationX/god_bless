package school.faang.letsPlayBank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@AllArgsConstructor
@Getter
@ToString
public class Account {
    private final int id;
    private double balance;
    private final Lock lock = new ReentrantLock();

    public boolean withdraw(double amount) {
        lock.lock();
        try {
            System.out.println("Withdrawing " + amount + " from account " + id);
            if (balance >= amount) {
                balance -= amount;
                return true;
            }
        } finally {
            lock.unlock();
        }
        return false;
    }

    public void deposit(double amount) {
        lock.lock();
        try {
            System.out.println("Depositing " + amount + " to account " + id);
            balance += amount;
        } finally {
            lock.unlock();
        }
    }
}
