package school.faang;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.util.concurrent.locks.ReentrantLock;

@AllArgsConstructor
@Slf4j
@Getter
@EqualsAndHashCode
public class Account {
    private final int id;
    private BigDecimal balance;
    private final ReentrantLock lock = new ReentrantLock();

    public void deposit(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            log.warn("Invalid deposit amount: {}. Amount must be positive.", amount);
            return;
        }
        lock.lock();
        try {
            balance = balance.add(amount);
            log.info("{} has been added to account with id {}. Updated balance: {}", amount, id, balance);
        } finally {
            lock.unlock();
        }
    }

    public void withdraw(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            log.warn("Invalid withdrawal amount: {}. Amount must be positive.", amount);
            return;
        }
        lock.lock();
        try {
            if (amount.compareTo(balance) > 0) {
                log.warn("Insufficient funds for withdrawal of {} from account with id {}. Current balance: {}",
                        amount, id, balance);
                return;
            }
            balance = balance.subtract(amount);
            log.info("{} has been withdrawn from account with id {}. Updated balance: {}", amount, id, balance);
        } finally {
            lock.unlock();
        }
    }

    public BigDecimal getBalance() {
        lock.lock();
        try {
            return balance;
        } finally {
            lock.unlock();
        }
    }
}
