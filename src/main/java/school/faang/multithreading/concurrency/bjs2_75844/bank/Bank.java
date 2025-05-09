package school.faang.multithreading.concurrency.bjs2_75844.bank;

import lombok.extern.slf4j.Slf4j;

import java.util.Comparator;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
public class Bank {
    private static final String NULL_ACCOUNT = "One of the account is null";
    private static final String EQUAL_ACCOUNTS = "There is the same account for sender and receiver";

    private final Map<UUID, Account> accountMap = new ConcurrentHashMap<>();

    public void addAccount(Account account) {
        accountMap.put(account.getId(), account);
    }

    public void transfer(UUID from, UUID to, double amount) {
        Account fromAccount = accountMap.get(from);
        Account toAccount = accountMap.get(to);

        checkAccountsForNull(fromAccount, toAccount);
        checkAccountsForEquality(fromAccount, toAccount);

        Account firstLock;
        Account secondLock;
        if (fromAccount.getId().compareTo(toAccount.getId()) < 0) {
            firstLock = fromAccount;
            secondLock = toAccount;
        } else {
            firstLock = toAccount;
            secondLock = fromAccount;
        }
        firstLock.getLock().lock();
        secondLock.getLock().lock();
        try {
            fromAccount.withdraw(amount);
            toAccount.deposit(amount);
            log.info("Transfer of {} is successful from {} to {}", amount, fromAccount, toAccount);
        } catch (RuntimeException e) {
            log.error(e.getMessage());
        } finally {
            firstLock.getLock().unlock();
            secondLock.getLock().unlock();
        }
    }

    public double getTotalBalance() {
        double value;
        accountMap.values().stream()
                .sorted(Comparator.comparing(Account::getId))
                .forEach(account -> account.getLock().lock());
        try {
            value = accountMap.values().stream()
                    .mapToDouble(Account::getBalance)
                    .sum();
        } finally {
            accountMap.values().stream()
                    .sorted(Comparator.comparing(Account::getId).reversed())
                    .forEach(account -> account.getLock().unlock());
        }
        return Math.round(value * 100.0) / 100.0;
    }

    private void checkAccountsForNull(Account fromAccount, Account toAccount) {
        if (fromAccount == null || toAccount == null) {
            log.error(NULL_ACCOUNT);
            throw new RuntimeException(NULL_ACCOUNT);
        }
    }

    private void checkAccountsForEquality(Account fromAccount, Account toAccount) {
        if (Objects.equals(fromAccount.getId(), toAccount.getId())) {
            log.error(EQUAL_ACCOUNTS);
            throw new RuntimeException(EQUAL_ACCOUNTS);
        }
    }
}
