package school.faang.bjs2_93337;

import lombok.Getter;

import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Bank {
    @Getter
    private Map<Integer, Account> accounts;
    private Lock lock = new ReentrantLock();

    public Bank(Map<Integer, Account> accounts) {
        this.accounts = accounts;
    }

    public boolean transfer(int fromAccountId, int toAccountId, double amount) {
        synchronized (lock) {
            Account fromAccount = accounts.get(fromAccountId);
            Account toAccount = accounts.get(toAccountId);
            if (fromAccount.getBalance() > 0 && fromAccount.getBalance() > amount) {
                fromAccount.withdraw(amount);
                toAccount.deposit(amount);
                return true;
            } else {
                return false;
            }
        }
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
