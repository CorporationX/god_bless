package school.faang.play_bank;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Getter
@EqualsAndHashCode
public class Account {
    private final int id;
    private double balance;
    private final Lock lock = new ReentrantLock();

    public Account(int id, double balance) {
        this.id = id;
        this.balance = balance;
    }

    public void deposit(double amount) {
        lock.lock();
        this.balance += amount;
        lock.unlock();
    }

    public void withdraw(double amount) {
        lock.lock();
        this.balance -= amount;
        lock.unlock();
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", balance=" + balance +
                '}';
    }
}
