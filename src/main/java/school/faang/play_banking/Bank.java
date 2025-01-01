package school.faang.play_banking;

import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
public class Bank {
    private final Map<Integer, Account> accounts = new ConcurrentHashMap<>();

    public boolean transfer(int fromAccountId, int toAccountId, double amount) {
        Account fromAccount = accounts.get(fromAccountId);
        Account toAccount = accounts.get(toAccountId);
        if (fromAccount == null || toAccount == null) {
            log.info("Account didn't find");
            return false;
        }
        Account firstLock = fromAccountId < toAccountId ? fromAccount : toAccount;
        Account secondLock = fromAccountId < toAccountId ? toAccount : fromAccount;

        firstLock.getLock().lock();
        secondLock.getLock().lock();


//        fromAccount.getLock().lock();
//        toAccount.getLock().lock();
        try {
            if (!fromAccount.withdraw(amount)) {
                return false;
            }
            toAccount.deposit(amount);
            log.info("Transfer successfully completed");
            return true;
        } finally {
//            fromAccount.getLock().unlock();
//            toAccount.getLock().unlock();
            firstLock.getLock().unlock();
            secondLock.getLock().unlock();
        }
    }

    public double getTotalBalance() {
        return accounts.values().stream()
                .mapToDouble(Account::getBalance)
                .sum();
    }

    public void addAccount(Account account) {
        accounts.put(account.getId(), account);
    }
}
