package school.faangSprint4.t16;

import java.util.concurrent.ConcurrentHashMap;

public class Bank {
    private final ConcurrentHashMap<Integer, Account> accounts;

    public Bank() {
        this.accounts = new ConcurrentHashMap<>();
    }

    public void addAccount(Account account) {
        accounts.put(account.getId(), account);
    }

    public boolean transfer(int fromAccountId, int toAccountId, double amount) {
        Account fromAccount = accounts.get(fromAccountId);
        Account toAccount = accounts.get(toAccountId);

        if (fromAccount == null || toAccount == null || amount <= 0) {
            return false;
        }

        Account firstLock = fromAccount.getId() < toAccount.getId() ? fromAccount : toAccount;
        Account secondLock = fromAccount.getId() < toAccount.getId() ? toAccount : fromAccount;

        firstLock.lock.lock();
        try {
            secondLock.lock.lock();
            try {
                if (fromAccount.getBalance() >= amount) {
                    fromAccount.withdraw(amount);
                    toAccount.deposit(amount);
                    return true;
                }
                return false;
            } finally {
                secondLock.lock.unlock();
            }
        } finally {
            firstLock.lock.unlock();
        }
    }

    public double getTotalBalance() {
        return accounts.values().stream()
                .mapToDouble(Account::getBalance)
                .sum();
    }
}