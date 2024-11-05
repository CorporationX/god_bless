package school.faang.letsPlayBank;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public class Bank {
    private final Map<Integer, Account> accounts = new HashMap<>();

    public void addAccount(Account account) {
        accounts.put(account.getId(), account);
    }

    public void transfer(int from, int to, double amount) {
        Account fromAccount = accounts.get(from);
        Account toAccount = accounts.get(to);

        if (fromAccount == null || toAccount == null) {
            return;
        }

        Account firstLock = fromAccount.getId() < toAccount.getId() ? fromAccount : toAccount;
        Account secondLock = fromAccount.getId() < toAccount.getId() ? toAccount : fromAccount;

        firstLock.getLock().lock();
        secondLock.getLock().lock();

        try {
            if (fromAccount.withdraw(amount)) {
                toAccount.deposit(amount);
                System.out.println("Transfer successful: " + amount + " from " + fromAccount.getId() + " to " + toAccount.getId());
            } else {
                System.out.println("Transfer failed, not enough balance in account " + fromAccount.getId());
            }
        } finally {
            fromAccount.getLock().unlock();
            toAccount.getLock().unlock();
        }
    }

    public double getTotalBalance() {
        return accounts.values()
                .stream()
                .mapToDouble(Account::getBalance)
                .sum();
    }
}
