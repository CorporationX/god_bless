package school.faang.multithreading.concurrency.bjs2_75844.bank;

import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
public class Bank {
    private final Map<UUID, Account> accountMap = new ConcurrentHashMap<>();

    public void addAccount(Account account) {
        accountMap.put(account.getId(), account);
    }

    public boolean transfer(UUID from, UUID to, double amount) {
        Account fromAccount = accountMap.get(from);
        Account toAccount = accountMap.get(to);

        if (fromAccount == null || toAccount == null) {
            log.warn("One of the account is null, from = {}, to = {}", fromAccount, toAccount);
            return false;
        }
        if (fromAccount.getId().equals(toAccount.getId())) {
            log.warn("There the same account for sender and receiver");
            return false;
        }
        Account firstLock;
        Account secondLock;
        if (fromAccount.getId().compareTo(toAccount.getId()) < 0) {
            firstLock = fromAccount;
            secondLock = toAccount;
        } else {
            firstLock = toAccount;
            secondLock = fromAccount;
        }
        firstLock.getLock().lock();
        secondLock.getLock().lock();

        try {
            if (fromAccount.withdraw(amount)) {
                toAccount.deposit(amount);
                log.info("Transfer of {} is successful from {} to {}", amount, fromAccount, toAccount);
                return true;
            } else {
                return false;
            }
        } finally {
            firstLock.getLock().unlock();
            secondLock.getLock().unlock();
        }
    }

    public double getTotalBalance() {
        double value = accountMap.values().stream()
                .mapToDouble(Account::getBalance)
                .sum();
        return Math.round(value * 100.0) / 100.0;
    }
}
