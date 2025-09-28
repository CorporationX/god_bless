package school.faang.bjs2_93325;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Getter
@AllArgsConstructor
@ToString
public class Account {
    private final int id;
    private double balance;
    private static final Lock lock = new ReentrantLock();

    public void deposit(double amount) {
        lock.lock();
        balance += amount;
        lock.unlock();
    }

    public void withdraw(double amount) {
        lock.lock();
        balance -= amount;
        lock.unlock();
    }
}
