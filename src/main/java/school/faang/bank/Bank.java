package school.faang.bank;

import java.util.HashMap;
import java.util.Map;

public class Bank {
    private Map<Integer, Account> accounts = new HashMap<>();

    public void addAccount(Account account) {
        accounts.put(account.getId(), account);
    }

    public boolean transfer(int fromAccountId, int toAccountId, double amount) {
        Account fromAccount = accounts.get(fromAccountId);
        Account toAccount = accounts.get(toAccountId);

        Account firstLock = fromAccountId < toAccountId ? fromAccount : toAccount;
        Account secondLock = fromAccountId < toAccountId ? toAccount : fromAccount;

        firstLock.getLock().lock();
        secondLock.getLock().lock();

        try {
            if (fromAccount.getBalance() < amount) {
                System.out.println("Перевод " + amount + " ед. со счета " + fromAccount.getId()
                        + " невозможен, недостаточно средств");
                return false;
            }
            fromAccount.withdraw(amount);
            toAccount.deposit(amount);
            System.out.println("Перевод " + amount + " ед. между " + fromAccount.getId() + " и "
                    + toAccount.getId() + " прошел успешно");
            return true;
        } finally {
            firstLock.getLock().unlock();
            secondLock.getLock().unlock();
        }
    }

    public double getTotalBalance() {
        return accounts.values().stream()
                .map(Account::getBalance)
                .reduce(0.0, Double::sum);
    }
}
