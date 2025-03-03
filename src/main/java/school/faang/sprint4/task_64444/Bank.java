package school.faang.sprint4.task_64444;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

@Slf4j
public class Bank {
    private final Map<Integer, Account> accounts = new HashMap<>();

    public void addAccount(Account account) {
        if (accounts.containsKey(account.getId())) {
            log.warn("The {} account already exists", account);
        }
        accounts.put(account.getId(), account);
    }

    public boolean transfer(int fromAccountId, int toAccountId, double amount) {
        ReentrantLock fromLock = accounts.get(fromAccountId).getLock();
        ReentrantLock toLock = accounts.get(toAccountId).getLock();

        fromLock.lock();
        try {
            if (!accounts.get(fromAccountId).withdraw(amount)) {
                return false;
            }
        } finally {
            fromLock.unlock();
        }

        toLock.lock();
        try {
            accounts.get(toAccountId).deposit(amount);
            return true;
        } finally {
            toLock.unlock();
        }
    }


    public double getTotalBalance() {
        double total = accounts.values().stream()
                .map(Account::getBalance)
                .reduce(0D, (Double::sum));

        accounts.values().forEach(this::printAccountInfo);

        return total;
    }

    private void printAccountInfo(Account account) {
        System.out.printf("Account %d start balance 50.0, now %f \n", account.getId(), account.getBalance());
    }
}
