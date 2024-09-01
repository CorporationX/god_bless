package faang.school.godbless.BJS2_25269;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class Bank {
    private final ConcurrentMap<Long, Account> accounts = new ConcurrentHashMap<>();

    public void addAccount(Account account) {
        accounts.putIfAbsent(account.getId(), account);
    }

    public int getTotalBalance() {
        return accounts.values().stream()
                .mapToInt(Account::getBalance)
                .sum();
    }

    public boolean transfer(Account fromAccount, Account toAccount, int money) {
        if (fromAccount.getBalance() < money) {
            return false;
        }
        synchronized (fromAccount.getLock()) {
            synchronized (toAccount.getLock()) {
                fromAccount.withdraw(money);
                toAccount.deposit(money);
            }
        }
        return true;
    }
}



