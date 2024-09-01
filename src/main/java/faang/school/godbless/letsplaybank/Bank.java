package faang.school.godbless.letsplaybank;

import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
public class Bank {
    private final Map<Integer, Account> accounts;

    public Bank() {
        this.accounts = new ConcurrentHashMap<>();
    }

    public void addAccount(Account account) {
        accounts.putIfAbsent(account.getId(), account);
    }

    public void transfer(int fromId, int toId, double amount) {
        Account fromAccount = accounts.get(fromId);
        Account toAccount = accounts.get(toId);
        if (fromAccount == null || toAccount == null) {
            log.info("Account not found.");
            return;
        }
        Account firstLock = fromAccount.getId() < toAccount.getId() ? fromAccount : toAccount;
        Account secondLock = fromAccount.getId() < toAccount.getId() ? toAccount : fromAccount;
        firstLock.getLock().lock();
        try {
            secondLock.getLock().lock();
            try {
                if (fromAccount.withdraw(amount)) {
                    toAccount.deposit(amount);
                    log.info("Transfer successful: {} from Account {} to Account {}", amount, fromId, toId);
                } else {
                    log.info("Insufficient funds in Account {}", fromId);
                }
            } finally {
                secondLock.getLock().unlock();
            }
        } finally {
            firstLock.getLock().unlock();
        }
    }

    public double getTotalBalance() {
        return accounts.values().stream()
                .mapToDouble(Account::getBalance)
                .sum();
    }
}