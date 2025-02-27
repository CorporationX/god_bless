package bjs262619;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Getter
@Slf4j
public class Bank implements Runnable {
    private static final int THREAD_SLEEP_IN_MS = 1000;
    private final Map<Integer, Account> accounts = new ConcurrentHashMap<>();
    private final Lock lock = new ReentrantLock();

    public void addAccount(Account account) {
        accounts.put(account.getId(), account);
    }

    public boolean transfer(int fromAccountId, int toAccountId, double amount) {
        Account accountFrom = accounts.get(fromAccountId);
        Account accountTo = accounts.get(toAccountId);
        if (accountFrom == null || accountTo == null) {
            log.info("One of the accounts was not found");
            return false;
        }
        Account firstLock = fromAccountId < toAccountId ? accountFrom : accountTo;
        Account secondLock = fromAccountId < toAccountId ? accountTo : accountFrom;
        firstLock.getLock().lock();
        secondLock.getLock().lock();
        try {
            if (accountFrom.withdraw(amount)) {
                accountTo.deposit(amount);
                log.info("Transfer completed successfully: {} from account {} to account {}",
                        amount, fromAccountId, toAccountId);
                return true;
            } else {
                log.info("The transfer failed in {}. Insufficient funds in the account {}",
                        Thread.currentThread().getName(), fromAccountId);
                return false;
            }
        } finally {
            firstLock.getLock().unlock();
            secondLock.getLock().unlock();
        }
    }

    public double getTotalBalance() {
        try {
            lock.lock();
            return accounts.values().stream().mapToDouble(Account::getBalance).sum();
        } finally {
            lock.unlock();
        }
    }

    @Override
    public void run() {
        try {
            Thread.sleep(THREAD_SLEEP_IN_MS);
        } catch (InterruptedException e) {
            log.info("Transfer has interrupted in {}", Thread.currentThread().getName());
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }
}
