package faang.school.godbless.bank;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.util.concurrent.locks.ReentrantLock;

@Data
@AllArgsConstructor
public class Account {

    private int id;
    private BigDecimal balance;
    private final ReentrantLock LOCK = new ReentrantLock();

    public BigDecimal getBalance() {
        LOCK.lock();
        try {
            return balance;
        } finally {
            LOCK.unlock();
        }
    }

    public void deposit(BigDecimal value) {
        LOCK.lock();
        try {
            balance = balance.add(value);
        } finally {
            LOCK.unlock();
        }
    }

    public void withdraw(BigDecimal value) {
        LOCK.lock();
        try {
            balance = balance.subtract(value);
        } finally {
            LOCK.unlock();
        }
    }
}
