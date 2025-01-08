package school.faang.task_51066;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@Slf4j
@Getter
public class Bank {
    private final ConcurrentMap<UUID, Account> accounts = new ConcurrentHashMap<>();

    public void transfer(UUID fromAccountId, UUID toAccountId, double amount) {
        Account fromAccount = accounts.get(fromAccountId);
        if (fromAccount.getBalance() < amount) {
            throw new IllegalArgumentException("Insufficient funds from account: " + fromAccountId);
        }

        Account toAccount = accounts.get(toAccountId);
        fromAccount.withdraw(amount);
        toAccount.deposit(amount);
    }

    public double getTotalBalance() {
        return accounts.values().stream()
                .map(Account::getBalance)
                .reduce(0.0, Double::sum);
    }

    public void addAccount(Account account) {
        accounts.put(account.getId(), account);
    }
}
