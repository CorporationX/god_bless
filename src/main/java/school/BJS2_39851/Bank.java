package school.BJS2_39851;

import java.util.HashMap;
import java.util.Map;

public class Bank {

    private volatile Map<Integer, Account> accounts = new HashMap<>();

    public void transfer(int fromAccountId, int toAccountId, double amount) {
        double sumFromAccount = accounts.get(fromAccountId).getBalance();
        Account fromAccount = accounts.get(fromAccountId);
        Account toAccount = accounts.get(toAccountId);
        Account accountForLock1 = fromAccountId > toAccountId ? fromAccount : toAccount;
        Account accountForLock2 = fromAccountId > toAccountId ? toAccount : fromAccount;
        if (sumFromAccount < amount) {
            System.out.println("Недостаточно средств");
        }
        synchronized (accountForLock1) {
            synchronized (accountForLock2) {
                fromAccount.withdraw(amount);
                toAccount.deposit(amount);
            }
        }
        System.out.println("Перевод прошел успешно");
    }

    public double getTotalBalance() {
        return accounts.values().stream().mapToDouble(Account::getBalance).sum();
    }

    public synchronized void addAccounts(int id, Account account) {
        accounts.put(id, account);
    }
}
