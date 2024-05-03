package faang.school.godbless.banks;

import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
public class Bank {
    private final Map<Integer, Account> accounts;

    public Bank() {
        this.accounts = new ConcurrentHashMap<>();
    }

    public void addAccount(Account account) {
        accounts.put(account.getId(), account);
    }

    public boolean transfer(int fromAccountId, int toAccountId, double amount) {
        if (!accounts.containsKey(fromAccountId)) {
            log.error("Invalid account id {}", fromAccountId);
            return false;
        }

        if (!accounts.containsKey(toAccountId)) {
            log.error("Invalid account id {}", toAccountId);
            return false;
        }

        Account fromAccount = accounts.get(fromAccountId);
        Account toAccount = accounts.get(toAccountId);

        try {
            if (fromAccountId > toAccountId) {
                fromAccount.getReentrantLock().lock();
                toAccount.getReentrantLock().lock();
            } else {
                toAccount.getReentrantLock().lock();
                fromAccount.getReentrantLock().lock();
            }

            if (isTransferValid(fromAccount, amount)) {
                fromAccount.withdraw(amount);
                toAccount.deposit(amount);
                return true;
            }
        } finally {
            if (fromAccountId > toAccountId) {
                toAccount.getReentrantLock().unlock();
                fromAccount.getReentrantLock().unlock();
            } else {
                fromAccount.getReentrantLock().unlock();
                toAccount.getReentrantLock().unlock();
            }
        }

        return false;
    }

    public double getTotalBalance(int accountId) {
        if (accounts.containsKey(accountId)) {
            return accounts.get(accountId).getBalance().get();
        }
        return 0;
    }

    private boolean isTransferValid(Account account, double amount) {
        return account.isEnoughBalance(amount);
    }
}
