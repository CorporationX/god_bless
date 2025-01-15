package school.faang.task_51114;

import java.util.HashMap;
import java.util.Map;

public class Bank {
    private final Map<Integer, Account> accounts = new HashMap<>();

    public void addAccount(Account account) {
        accounts.put(account.getId(), account);
    }

    public boolean transfer(int fromAccountId, int toAccountId, double amount) {
        Account fromAccount = accounts.get(fromAccountId);
        Account toAccount = accounts.get(toAccountId);

        if (fromAccount == null || toAccount == null) {
            System.out.println("One of the accounts does not exist.");
            return false;
        }

        Account firstLock = fromAccountId < toAccountId ? fromAccount : toAccount;
        Account secondLock = fromAccountId < toAccountId ? toAccount : fromAccount;

        try {
            if (fromAccount.withdraw(amount)) {
                toAccount.deposit(amount);
                System.out.println("Transferred " + amount + " from account "
                        + fromAccountId + " to account " + toAccountId);
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
        double totalBalance = 0;
        for (Account account : accounts.values()) {
            account.getLock().lock();
            try {
                totalBalance += account.getBalance();
            } finally {
                account.getLock().unlock();
            }
        }
        return totalBalance;
    }
}