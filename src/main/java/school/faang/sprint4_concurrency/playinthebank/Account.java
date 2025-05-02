package school.faang.sprint4_concurrency.playinthebank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.ReentrantLock;

@Slf4j
@Data
@AllArgsConstructor
public class Account {
    private final int id;
    private double balance;
    private final ReentrantLock lock = new ReentrantLock();

    public void deposit(double amount) {
        lock.lock();
        try {
            balance += amount;
            log.info("Баланс пополнен на сумму - {}. Сейчас баланс равен: {}\n", amount, balance);
        } finally {
            lock.unlock();
        }
    }

    public boolean withdraw(double amount) {
        lock.lock();
        try {
            if (balance >= amount) {
                balance -= amount;
                log.info("Баланс уменьшен. Сейчас равен: {}\n", balance);
                return true;
            } else {
                log.info("Ошибка.Баланс меньше, чем сумма вычета. Сумма вычета - {}, баланс - {}.\n", amount, balance);
                return false;
            }
        } finally {
            lock.unlock();
        }
    }
}