package school.faang.play.the.bank;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Bank {
    Map<Integer, Account> accounts = new ConcurrentHashMap<>();

    public boolean transfer(int fromAccountId, int toAccountId, double amount) {
        Account fromAccount = accounts.get(fromAccountId);
        Account toAccount = accounts.get(toAccountId);

        if (fromAccount == null || toAccount == null) {
            System.out.println("некорректный id аккаунта");
            return false;
        }
        Object firstLock = fromAccountId < toAccountId ? fromAccount.getLock() : toAccount.getLock();
        Object secondLock = fromAccountId >= toAccountId ? fromAccount.getLock() : toAccount.getLock();

        synchronized (firstLock) {
            synchronized (secondLock) {
                if (fromAccount.getBalance() < amount) {
                    System.out.println("на счету " + fromAccount + " недостаточно средств");
                    return false;
                }
                fromAccount.withdraw(amount);
                toAccount.deposit(amount);
                System.out.println("Перевод был успешно выполнен: " + fromAccount + " -> " + toAccount);
                return true;
            }
        }
    }

    public void add(Account account) {
        accounts.put(account.getId(), account);
    }

    public double getTotalBalance() {
        return accounts.values().stream()
                .map(Account::getBalance)
                .reduce(0.0, Double::sum);
    }
}
