package faang.school.godbless.letsPlayBank;

import lombok.Data;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Data
public class Bank {
    private Map<Integer, Account> accounts;

    public Bank() {
        this.accounts = new ConcurrentHashMap<>();
    }

    public void addAccount(Account account) {
        accounts.put(account.getId(), account);
    }

    public boolean transfer(int fromAccountId, int toAccountId, double amount) {
        Account fromAccount = accounts.get(fromAccountId);
        Account toAccount = accounts.get(toAccountId);

        Account firstLock = fromAccountId < toAccountId ? fromAccount : toAccount;
        Account secondLock = fromAccountId < toAccountId ? toAccount : fromAccount;

        firstLock.getLock().lock();
        secondLock.getLock().lock();
        try {
            if (fromAccount.getBalance() >= amount) {
                fromAccount.withdraw(amount);
                toAccount.deposit(amount);
                return true;
            } else {
                return false;
            }
        } finally {
            secondLock.getLock().unlock();
            firstLock.getLock().unlock();
        }
    }

}
