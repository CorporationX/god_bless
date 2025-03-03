package school.faang.sprint4.task_64444;

import lombok.Getter;
import lombok.ToString;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

@ToString
@Getter
public class Account {
    private static final AtomicInteger ID_GENERATOR = new AtomicInteger();

    private final int id = ID_GENERATOR.getAndIncrement();
    private final ReentrantLock lock = new ReentrantLock();
    private double balance = 50;

    public void deposit(double amount) {
        changeBalance(amount);
    }

    public boolean withdraw(double amount) {
        return changeBalance(-amount);
    }

    private boolean changeBalance(double amount) {
        if (balance + amount < 0) {
            return false;
        }

        balance += amount;
        return true;
    }
}
