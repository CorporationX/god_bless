package faang.school.godbless.sprint4.bank;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Bank {
    private final Map<Integer, Account> accounts = new ConcurrentHashMap<>();

    public boolean transfer(int from, int to, int amount) {
        Account fromAccount = accounts.get(from);
        Account toAccount = accounts.get(to);
        fromAccount.getLock().lock();
        try {
            toAccount.getLock().lock();
            try {
                if(fromAccount.getBalance() > amount) {
                    fromAccount.withdraw(amount);
                    toAccount.deposit(amount);
                    return true;
                }else {
                    return false;
                }
            }finally {
                toAccount.getLock().unlock();
            }
        }finally {
            fromAccount.getLock().unlock();
        }

    }

    public int getTotalBalance() {
        int totalBalance = 0;
        for (Account account : accounts.values()) {
            totalBalance += account.getBalance();
        }
        return totalBalance;

    }
    public void addAccount(Account account) {
        accounts.put(account.getId(), account);
    }
}
