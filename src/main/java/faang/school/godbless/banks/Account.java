package faang.school.godbless.banks;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.ReentrantLock;

@Data
@Slf4j
public class Account {
    private static int startId = 0;
    private int id;
    private AtomicReference<Double> balance;
    private ReentrantLock reentrantLock;

    public Account(double balance) {
        this.id = startId++;
        this.balance = new AtomicReference<>(balance);
        this.reentrantLock = new ReentrantLock();
    }

    public void deposit(double amount) {
        balance.updateAndGet(x -> x + amount);
    }

    public void withdraw(double amount) {
        balance.updateAndGet(x -> x - amount);
    }

    public boolean isEnoughBalance(double amount) {
        return balance.get() >= amount;
    }
}
