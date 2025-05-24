package school.faang.bank;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Bank {
    private final Map<Integer, Account> accounts = new ConcurrentHashMap<>();

    public void addAccount(Account account) {
        accounts.put(account.getId(), account);
    }

    public boolean transfer(int fromId, int toId, double amount) {
        if (fromId == toId) {
            return false;
        }

        Account from = accounts.get(fromId);
        Account to = accounts.get(toId);

        Account firstLock = fromId < toId ? from : to;
        Account secondLock = fromId < toId ? to : from;

        firstLock.getLock().lock();
        secondLock.getLock().lock();
        try {
            if (from.withdraw(amount)) {
                to.deposit(amount);
                return true;
            } else {
                return false;
            }
        } finally {
            secondLock.getLock().unlock();
            firstLock.getLock().unlock();
        }
    }

    public double getTotalBalance() {
        double total = 0.0;
        for (Account account : accounts.values()) {
            account.getLock().lock();
        }
        try {
            for (Account account : accounts.values()) {
                total += account.getBalance();
            }
        } finally {
            for (Account account : accounts.values()) {
                account.getLock().unlock();
            }
        }
        return total;
    }
}
