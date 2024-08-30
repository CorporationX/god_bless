package faang.school.godbless.BJS2_25440;

import lombok.Getter;
import lombok.ToString;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;

@Getter
@ToString
public class Bank {
    private final Map<Integer, Account> accounts = new ConcurrentHashMap<>();

    public void addAccount(Account account) {
        accounts.put(account.getId(), account);
    }

    public boolean transfer(int fromAccountId, int toAccountId, long amount) {
        Account fromAccount = getAccountOrThrow(fromAccountId);
        Account toAccount = getAccountOrThrow(toAccountId);

        Account firstAccount;
        Account secondAccount;
        if (fromAccountId < toAccountId) {
            firstAccount = fromAccount;
            secondAccount = toAccount;
        } else {
            firstAccount = toAccount;
            secondAccount = fromAccount;
        }

        return executeTransfer(fromAccount, toAccount, firstAccount.getLock(), secondAccount.getLock(), amount);
    }

    private boolean executeTransfer(Account fromAccount, Account toAccount, Lock firstLock, Lock secondLock, long amount) {
        firstLock.lock();
        try {
            secondLock.lock();
            try {
                if (fromAccount.getBalance() < amount) {
                    System.out.println("Перевод не выполнен: " + amount + " с аккаунта " +
                            fromAccount.getId() + " на аккаунт " + toAccount.getId() + " из-за недостатка средств");
                    return false;
                }
                fromAccount.withdraw(amount);
                toAccount.deposit(amount);
                System.out.println("Перевод успешно выполнен: " + amount + " с аккаунта " +
                        fromAccount.getId() + " на аккаунт " + toAccount.getId());
                return true;
            } finally {
                secondLock.unlock();
            }
        } finally {
            firstLock.unlock();
        }
    }

    private Account getAccountOrThrow(int accountId) {
        return Optional.ofNullable(accounts.get(accountId))
                .orElseThrow(() -> new IllegalArgumentException("Аккаунт " + accountId + " не найден"));
    }


    public long getTotalBalance() {
        return accounts.values().stream()
                .mapToLong(Account::getBalance)
                .sum();
    }
}
