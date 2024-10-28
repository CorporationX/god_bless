package school.faang.task424.account;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Data
public class Account {
    private int id;
    private static int accountCount = 0;
    private BigDecimal balance ;
    private final Lock lock = new ReentrantLock();

    public Account(double balance) {
        this.id = accountCount++;
        this.balance = new BigDecimal(balance);
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
            balance = balance.subtract(amount);
        } finally {
            lock.unlock();
        }
    }

}
