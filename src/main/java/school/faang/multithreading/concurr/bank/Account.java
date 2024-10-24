package school.faang.multithreading.concurr.bank;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.util.concurrent.locks.ReentrantLock;

@Slf4j
public class Account {
    @Getter
    private final int id;
    private BigDecimal balance;
    @Getter
    private final ReentrantLock lock = new ReentrantLock();

    public Account(int id, BigDecimal startBalance) {
        this.id = id;
        balance = startBalance;
    }

    public BigDecimal getBalance() {
        lock.lock();
        try {
            return balance;
        } finally {
            lock.unlock();
        }
    }

    public void deposit(BigDecimal amount) {
        lock.lock();
        try {
            balance = balance.add(amount);
        } finally {
            lock.unlock();
        }
    }

    public void withdraw(BigDecimal amount) {
        lock.lock();
        try {
            if (balance.compareTo(amount) < 0) {
                log.error("На счете №{}, недостаточно средств для списания", id);
                throw new RuntimeException("Недостаточно средств");
            }
            balance = balance.subtract(amount);
        } finally {
            lock.unlock();
        }
    }
}
