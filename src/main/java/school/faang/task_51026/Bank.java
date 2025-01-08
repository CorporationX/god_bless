package school.faang.task_51026;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class Bank {
    @Getter
    private final Map<Integer, Account> accounts = new HashMap<>();
    private final AtomicInteger counter = new AtomicInteger(0);

    public Account addAccount() {
        Account newAccount = new Account(counter.getAndIncrement());
        newAccount.setBalance(Math.random() * 100);
        accounts.put(newAccount.getId(), newAccount);
        return newAccount;
    }

    public boolean transfer(Account from, Account to, double amount) {
        int firstId = Math.min(from.getId(), to.getId());
        int secondId = Math.max(from.getId(), to.getId());
        accounts.get(firstId).getLock().lock();
        accounts.get(secondId).getLock().lock();

        try {
            if (from.getBalance() < amount) {
                System.out.println("Нет деняк");
                return false;
            }

            from.withdraw(amount);
            to.deposit(amount);

            return true;
        } finally {
            from.getLock().unlock();
            to.getLock().unlock();
        }
    }
}
