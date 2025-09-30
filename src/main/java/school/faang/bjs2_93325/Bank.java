package school.faang.bjs2_93325;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Getter
@Slf4j
public class Bank {
    private final Map<Integer, Account> accounts = new ConcurrentHashMap<>();
    private final AtomicReference<Double> totalBalance = new AtomicReference<>(0.0);
    private final Lock lock = new ReentrantLock();

    public void addAccount(Account account) {
        accounts.put(account.getId(), account);
    }

    public boolean transfer(int fromAccountId, int toAccountId, double amount) {
        try {
            Account accountStart = accounts.get(fromAccountId);
            Account accountFinish = accounts.get(toAccountId);
            if (accountStart == null || accountFinish == null) {
                log.warn("Один из счетов не найден: accountStart - {}, accountFinish - {}",
                        accountStart, accountFinish);
                return false;
            }

            if (accountStart.getBalance() >= amount) {
                accountStart.withdraw(amount);
                accountFinish.deposit(amount);
                log.info("Был сделан перевод со счета {} на счет {}", accountStart, accountFinish);
                return true;
            } else {
                log.info("На счетe {} не хватает денег");
                return false;
            }
        } catch (Exception e) {
            log.warn("Произошла неизвестная ошибка!!", e.getMessage());
            return false;
        }
    }


    public double getTotalBalance() {
        double balance = totalBalance.updateAndGet(d -> sumBalance());
        log.info("Получена общий баланс банка {}", balance);
        return balance;
    }

    private double sumBalance() {
        lock.lock();
        double sum = accounts.values().stream()
                .mapToDouble(Account::getBalance)
                .sum();
        lock.unlock();
        return sum;

    }
}
