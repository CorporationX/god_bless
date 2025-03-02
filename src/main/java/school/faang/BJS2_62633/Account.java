package school.faang.BJS2_62633;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.concurrent.locks.ReentrantLock;

@AllArgsConstructor
@Getter
public class Account {
    private final int id;
    private double balance;

    public final ReentrantLock lock = new ReentrantLock();

    public void deposit(double amount) {
        lock.lock();
        try {
            this.balance += amount;
        } finally {
            lock.unlock();
        }
    }

    public void withdraw(double amount) {
        lock.lock();
        try {
            this.balance -= amount;
        } finally {
            lock.unlock();
        }
    }
}
