package school.faang.bjs2_93337;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Slf4j
public class Bank {
    @Getter
    private Map<Integer, Account> accounts;
    private Lock lock = new ReentrantLock();

    public Bank(Map<Integer, Account> accounts) {
        this.accounts = accounts;
    }

    public boolean transfer(int fromAccountId, int toAccountId, double amount) {
        Account fromAccount = accounts.get(fromAccountId);
        Account toAccount = accounts.get(toAccountId);
        Account first = fromAccountId < toAccountId ? fromAccount : toAccount;
        Account second = fromAccountId < toAccountId ? toAccount : fromAccount;

        if (first.getLock().tryLock()) {
            try {
                if (second.getLock().tryLock()) {
                    try {
                        if (fromAccount.getBalance() > 0 && fromAccount.getBalance() > amount) {
                            fromAccount.withdraw(amount);
                            toAccount.deposit(amount);
                            log.info("transaction success: {} -> {} | {}", fromAccountId, toAccountId, amount);
                            return true;
                        } else {
                            log.info("transaction failure");
                            return false;
                        }
                    } finally {
                        second.getLock().unlock();
                    }
                }
            } finally {
                first.getLock().unlock();
            }
        }
        return false;
    }

    public double getTotalBalance() {
        synchronized (lock) {
            double sum = 0;
            try {
                for (Map.Entry<Integer, Account> e : accounts.entrySet()) {
                    sum = sum + e.getValue().getBalance();
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            return sum;
        }
    }
}
