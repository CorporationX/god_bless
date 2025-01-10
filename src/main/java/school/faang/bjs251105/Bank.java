package school.faang.bjs251105;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
@Getter
@RequiredArgsConstructor
public class Bank {

    private final Map<Integer, Account> accounts = new ConcurrentHashMap<>();

    public void transfer(int fromAccountId, int toAccountId, double amount) {
        Account fromAccount = accounts.get(fromAccountId);
        Account toAccount = accounts.get(toAccountId);

        if (fromAccount == null || toAccount == null) {
            log.error("One or both accounts do not exist");
            return;
        }

        if (fromAccount.getBalance() < amount) {
            log.error("Insufficient balance in account {}", fromAccountId);
            return;
        }

        Account firstLock;
        Account secondLock;

        if (fromAccountId < toAccountId) {
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
            log.info("Now the balance with id {} has decreased: {}", fromAccountId, fromAccount.getBalance());
            toAccount.deposit(amount);
            log.info("Now the balance with id {} has increased: {}", toAccountId, toAccount.getBalance());

            log.info("Transfer completed");

        } finally {
            firstLock.getLock().unlock();
            secondLock.getLock().unlock();
        }
    }

    public void addAccount(Account account) {
        accounts.put(account.getId(), account);
        log.info("Account with id {} has added", account.getId());
    }

    public void getTotalBalance() {
        double totalBalance = accounts.values().stream()
                .mapToDouble(Account::getBalance)
                .sum();
        log.info("Total balance is {}", totalBalance);
    }
}