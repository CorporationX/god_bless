package school.faang.BJS2_62633;

import lombok.NonNull;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

public class Bank {
    private final Map<Integer, Account> accounts = new ConcurrentHashMap<>();
    private final ReentrantLock coordinationLock = new ReentrantLock();

    public void addAccount(@NonNull Account account) {
        accounts.put(account.getId(), account);
    }

    public boolean transfer(int fromAccountId, int toAccountId, double amount) {
        ReentrantLock firstLock;
        ReentrantLock secondLock;

        coordinationLock.lock();
        try {
            if ((fromAccountId == 0 || toAccountId == 0 || fromAccountId == toAccountId
                    || accounts.get(fromAccountId).getBalance() < amount)) {
                System.out.printf("Transfer from account id %d to account id %d failed!\n",
                        fromAccountId, toAccountId);
                return false;
            }
            Account fromAccount = accounts.get(fromAccountId);
            Account toAccount = accounts.get(toAccountId);
            if (fromAccount == null || toAccount == null) {
                return false;
            }
            firstLock = fromAccountId < toAccountId ? fromAccount.lock : toAccount.lock;
            secondLock = fromAccountId < toAccountId ? toAccount.lock : fromAccount.lock;
        } finally {
            coordinationLock.unlock();
        }

        firstLock.lock();
        System.out.println("First Lock");
        try {
            secondLock.lock();
            System.out.println("Second Lock");
            try {
                accounts.compute(fromAccountId, (k, v) -> {
                    if (v == null) {
                        throw new IllegalArgumentException("Account with ID " + fromAccountId + " not found");
                    }
                    v.withdraw(amount);
                    return v;
                });
                accounts.compute(toAccountId, (k, v) -> {
                    if (v == null) {
                        throw new IllegalArgumentException("Account with ID " + toAccountId + " not found");
                    }
                    v.deposit(amount);
                    return v;
                });
                return true;
            } finally {
                secondLock.unlock();
                System.out.println("Second Unlock");
            }
        } finally {
            firstLock.unlock();
            System.out.println("First Unlock");
        }
    }

    public double getTotalBalance() {
        return accounts.values().stream()
                .mapToDouble(Account::getBalance)
                .sum();
    }
}