package school.faang;

import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
public class Bank {
    private final Map<Integer, Account> accounts = new ConcurrentHashMap<>();
    private static final Random random = new Random();

    public void addAccount(Account account) {
        accounts.put(account.getId(), account);
    }

    public synchronized double getTotalBalance() {
        return accounts.values().stream()
                .mapToDouble(Account::getBalance)
                .sum();
    }

    public boolean transfer(int fromAccountId, int toAccountId, double amount) {
        try {
            Thread.sleep(random.nextInt(3));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Account fromAccount = accounts.get(fromAccountId);
        Account toAccount = accounts.get(toAccountId);
        if (fromAccount == null) {
            log.error("No account with id: {}", fromAccountId);
            return false;
        } else  if (toAccount == null) {
            log.error("No account with id: {}", toAccountId);
            return false;
        }

        Account firstLock = fromAccountId < toAccountId ? fromAccount : toAccount;
        Account secondLock = fromAccountId < toAccountId ? toAccount : fromAccount;
        firstLock.getLock().lock();
        secondLock.getLock().lock();
        try {
            if (fromAccount.getBalance() < amount) {
                log.error("Couldn't perform a transaction. Insufficient funds.");
                return false;
            }
            fromAccount.withdraw(amount);
            toAccount.deposit(amount);
            log.info("Transfer of {} from account {} to account {} was successful.",
                    amount, fromAccountId, toAccountId);
            return true;
        } finally {
            firstLock.getLock().unlock();
            secondLock.getLock().unlock();
        }
    }
}
