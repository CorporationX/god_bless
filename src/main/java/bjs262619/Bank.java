package bjs262619;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Getter
@Slf4j
public class Bank {
    private final Map<Integer, Account> accounts = new ConcurrentHashMap<>();

    public void addAccount(Account account) {
        accounts.put(account.getId(), account);
    }

    public boolean transfer(int fromAccountId, int toAccountId, double amount) {
        Account accountFrom = accounts.get(fromAccountId);
        Account accountTo = accounts.get(toAccountId);
        if (accountFrom == null || accountTo == null) {
            log.info("One of the accounts was not found");
            return false;
        }
        Account firstLock = fromAccountId < toAccountId ? accountFrom : accountTo;
        Account secondLock = fromAccountId < toAccountId ? accountTo : accountFrom;
        firstLock.getLock().lock();
        secondLock.getLock().lock();
        try {
            if (accountFrom.withdraw(amount)) {
                accountTo.deposit(amount);
                log.info("Transfer completed successfully: {} from account {} to account {}",
                        amount, fromAccountId, toAccountId);
                return true;
            } else {
                log.info("The transfer failed in {}. Insufficient funds in the account {}",
                        Thread.currentThread().getName(), fromAccountId);
                return false;
            }
        } finally {
            firstLock.getLock().unlock();
            secondLock.getLock().unlock();
        }
    }

    public double getTotalBalance() {
        return accounts.values().stream().mapToDouble(Account::getBalance).sum();
    }
}
