package school.faang.sprint_4.task_51015;

import java.util.HashMap;
import java.util.Map;

public class Bank {
    private final Map<Integer, Account> accounts = new HashMap<>();

    public synchronized void addAccount(Account account) {
        accounts.put(account.getId(), account);
    }

    public boolean transfer(int fromAccountId, int toAccountId, double amount) {
        Account fromAccount;
        Account toAccount;
        synchronized (accounts) {
            fromAccount = accounts.get(fromAccountId);
            toAccount = accounts.get(toAccountId);
        }

        if (fromAccount != null
                && toAccount != null
                && fromAccount.getBalance() >= amount) {
            fromAccount.withdraw(amount);
            toAccount.deposit(amount);
            return true;
        }
        return false;
    }

    public double getTotalBalance() {
        Map<Integer, Account> copied = Map.copyOf(accounts);

        return copied.values()
                .stream()
                .mapToDouble(Account::getBalance)
                .sum();
    }
}
