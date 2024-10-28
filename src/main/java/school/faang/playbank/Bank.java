package school.faang.playbank;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;

public class Bank {
    private final Map<Integer, Account> accounts = new ConcurrentHashMap<>();

    public void addAccount(Account account) {
        accounts.put(account.getId(), account);
    }

    public boolean transfer(int fromAccountId, int toAccountId, double amount) {
        Account fromAccount = accounts.get(fromAccountId);
        Account toAccount = accounts.get(toAccountId);

        Account firstLock = fromAccountId < toAccountId ? fromAccount : toAccount;
        Account secondLock = fromAccountId < toAccountId ? toAccount : fromAccount;

        Lock first = firstLock.getLock();
        Lock second = secondLock.getLock();

        first.lock();
        try {
            second.lock();
            try {
                if (fromAccount.withdraw(amount)) {
                    toAccount.deposit(amount);
                    return true;
                } else {
                    return false;
                }
            } finally {
                second.unlock();
            }
        } finally {
            first.unlock();
        }
    }

    public double getTotalBalance() {
        return accounts.values().stream()
                .mapToDouble(Account::getBalance)
                .sum();
    }
}

