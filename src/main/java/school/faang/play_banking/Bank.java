package school.faang.play_banking;

import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

@Slf4j
public class Bank {
    private Map<Integer, Account> accounts = new ConcurrentHashMap<>();
    private final ReentrantLock totalBalanceLock = new ReentrantLock();

    public boolean transfer(int fromAccountId, int toAccountId, double amount) {
        Account fromAccount = accounts.get(fromAccountId);
        Account toAccount = accounts.get(toAccountId);
        if (fromAccount == null || toAccount == null) {
            log.info("Account didn't find");
            return false;
        }
        fromAccount.withdraw(amount);
        toAccount.deposit(amount);
    }



}
