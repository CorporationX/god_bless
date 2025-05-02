package school.faang.bank;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ConcurrentHashMap;

@Slf4j
public class Bank {
    private final ConcurrentHashMap<Integer, Account> accounts = new ConcurrentHashMap<>();

    public void addAccount(Account account) {
        log.debug("Thread: {}, executing addAccount()", Thread.currentThread().getName());
        accounts.put(account.getId(), account);
    }

    public boolean transfer(int fromAccountId, int toAccountId, double amount) {
        log.debug("Thread: {}, executing transfer()", Thread.currentThread().getName());
        final Account fromAccount = accounts.get(fromAccountId);
        final Account toAccount = accounts.get(toAccountId);

        if (fromAccount == null || toAccount == null) {
            log.error("One of accounts was not found");
            return false;
        }

        synchronized (fromAccount) {
            log.debug("Thread: {}, executing transfer(), entered synchronized (fromAccount)", Thread.currentThread().getName());
            synchronized (toAccount) {
                log.debug("Thread: {}, executing transfer(), entered synchronized (toAccount)", Thread.currentThread().getName());
                if (fromAccount.getBalance() < amount) {
                    log.error("Insufficient balance");
                    return false;
                }
                fromAccount.withdraw(amount);
                toAccount.deposit(amount);
            }
        }
        return true;
    }

    public double getTotalBalance() {
        log.debug("Thread: {}, executing getTotalBalance()", Thread.currentThread().getName());
        return accounts.values().stream().mapToDouble(Account::getBalance).sum();
    }
}
