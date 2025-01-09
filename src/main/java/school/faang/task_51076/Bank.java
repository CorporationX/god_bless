package school.faang.task_51076;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Bank {
    private final Map<Integer, Account> accounts = new ConcurrentHashMap<>();

    public void addAccount(Account account) {
        accounts.put(account.getId(), account);
    }

    public Map<Integer, Account> getAccounts() {
        return new HashMap<>(accounts);
    }

    public boolean transfer(int fromAccountId, int toAccountId, double amount) {
        int minId = Math.min(fromAccountId, toAccountId);
        int maxId = Math.max(fromAccountId, toAccountId);

        accounts.get(minId).getLock().lock();
        accounts.get(maxId).getLock().lock();

        try {
            Account fromAccount = accounts.get(fromAccountId);
            Account toAccount = accounts.get(toAccountId);

            if (!fromAccount.withdraw(amount)) {
                return false;
            }

            toAccount.deposit(amount);
            return true;

        } finally {
            accounts.get(minId).getLock().unlock();
            accounts.get(maxId).getLock().unlock();
        }
    }

    public double getTotalBalance() {
        return accounts.values().stream()
                .map(Account::getBalance)
                .reduce(0.0, Double::sum);
    }
}
