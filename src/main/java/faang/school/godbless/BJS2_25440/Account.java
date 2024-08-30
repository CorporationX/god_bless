package faang.school.godbless.BJS2_25440;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Getter
@ToString
@Setter
public class Account {
    private final int id;
    private long balance;
    private Lock lock;

    public Account(int id) {
        this.id = id;
        this.balance = 0;
        this.lock = new ReentrantLock();
    }
    public void deposit(long amount) {
        lock.lock();
        try {
            balance += amount;
        } finally {
            lock.unlock();
        }
    }
    public void withdraw(long amount) {
        lock.lock();
        try {
            balance -= amount;
        } finally {
            lock.unlock();
        }
    }
    public long getBalance() {
        lock.lock();
        try {
            return balance;
        } finally {
            lock.unlock();
        }
    }
}
