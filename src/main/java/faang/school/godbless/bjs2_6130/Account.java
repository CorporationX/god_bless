package faang.school.godbless.bjs2_6130;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Slf4j
@Getter
public class Account {
    private final int id;
    private final AtomicInteger balance;
    private final Lock lock = new ReentrantLock();

    public Account(int id, int startBalance) {
        this.id = id;
        this.balance = new AtomicInteger(startBalance);
    }

    public void deposit(int sum) {
        balance.getAndAdd(sum);
    }

    public void withdraw(int sum) {
        balance.compareAndSet(balance.get(), balance.get() - sum);
    }
}
