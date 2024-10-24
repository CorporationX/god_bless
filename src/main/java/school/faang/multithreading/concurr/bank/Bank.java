package school.faang.multithreading.concurr.bank;

import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
public class Bank {
    private final Map<Integer, Account> accounts = new ConcurrentHashMap<>();

    public void addAccount(Account account) {
        accounts.put(account.getId(), account);
    }

    public boolean transfer(int fromAccountId, int toAccountId, BigDecimal amount) {
        Account accountFrom = accounts.get(fromAccountId);
        Account accountTo = accounts.get(toAccountId);

        Account firstLock, secondLock;
        if (fromAccountId < toAccountId) {
            firstLock = accountFrom;
            secondLock = accountTo;
        } else {
            firstLock = accountTo;
            secondLock = accountFrom;
        }

        firstLock.getLock().lock();
        secondLock.getLock().lock();

        log.info("Начинаем операцию перевода");

        try {
            if (accountFrom.getBalance().compareTo(amount) < 0) {
                log.error("Недостаточно средств на счете №{}", fromAccountId);
                return false;
            }
            accountFrom.withdraw(amount);
            accountTo.deposit(amount);
            log.info("Перевод на сумму: {}, успешно выполнен", amount);
            return true;
        } finally {
            firstLock.getLock().unlock();
            secondLock.getLock().unlock();
        }
    }

    public BigDecimal getTotalBalance() {
        return accounts.values().stream()
                .map(Account::getBalance)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
