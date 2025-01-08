package school.faang.task_51026;

import lombok.Data;
import lombok.SneakyThrows;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Data
public class Account {
    private final int id;
    private double balance;
    private Lock lock = new ReentrantLock();

    @SneakyThrows
    public void deposit(double amount) {
        Thread.sleep(100);
        balance += amount;
    }

    @SneakyThrows
    public void withdraw(double amount) {
        Thread.sleep(100);
        balance -= amount;
    }
}
