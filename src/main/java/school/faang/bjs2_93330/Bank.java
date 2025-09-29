package school.faang.bjs2_93330;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

@Slf4j
@Getter
@Setter
public class Bank {
    private static final int SLEEPING_TIME = 3;
    private final Map<Integer, Account> accounts = new HashMap<>();
    private final ReadWriteLock lock = new ReentrantReadWriteLock();

    public boolean transfer(int fromAccountId, int toAccountId, double amount) {
        lock.writeLock().lock();
        try {
            TimeUnit.SECONDS.sleep(SLEEPING_TIME);
            Account fromAccount = accounts.get(fromAccountId);
            Account toAccount = accounts.get(toAccountId);
            if (fromAccount.getBalance() < amount) {
                log.info("Перевод от {} для {} на сумму {} не выполнен. Причина: недостаточно средств.",
                        fromAccount.getId(), toAccount.getId(), amount);
                return false;
            }
            fromAccount.withdraw(amount);
            toAccount.deposit(amount);
            log.info("Перевод от {} для {} на сумму {} успешно совершен.",
                    fromAccount.getId(), toAccount.getId(), amount);
            return true;
        } catch (InterruptedException e) {
            log.error("Поток был прерван во время выполнения перевода от {} для {} на сумму {}.",
                    fromAccountId, toAccountId, amount);
            return false;
        } finally {
            lock.writeLock().unlock();
        }
    }

    public double getTotalBalance() {
        lock.writeLock().lock();
        try {
            return accounts.values()
                    .stream()
                    .map(Account::getBalance)
                    .mapToDouble(Double::doubleValue)
                    .sum();
        } finally {
            lock.writeLock().unlock();
        }
    }
}
