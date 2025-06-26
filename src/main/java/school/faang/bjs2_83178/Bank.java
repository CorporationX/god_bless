package school.faang.bjs2_83178;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
@AllArgsConstructor
@Getter
public class Bank {

    private final Map<Integer, Account> accounts = new ConcurrentHashMap<>();

    public boolean transfer(int fromAccountId, int toAccountId, double amount) {
        Account fromAccount = accounts.get(fromAccountId);
        Account toAccount = accounts.get(toAccountId);

        if (fromAccount == null || toAccount == null) {
            log.info("account not found");
            return false;
        }

        Account firstAccount = fromAccountId < toAccountId ? fromAccount : toAccount;
        Account secondAccount = fromAccountId < toAccountId ? toAccount : fromAccount;

        firstAccount.getLock().lock();
        secondAccount.getLock().lock();
        try {
            if (fromAccount.getBalance() >= amount) {
                toAccount.deposit(amount);
                fromAccount.withdraw(amount);
                log.info("deposit success");
                return true;
            } else {
                log.info("insufficient funds");
                return false;
            }
        } finally {
            firstAccount.getLock().unlock();
            secondAccount.getLock().unlock();
        }
    }

    public synchronized double getTotalBalance() {
        return accounts.values().stream()
                .mapToDouble(Account::getBalance)
                .sum();
    }

}
