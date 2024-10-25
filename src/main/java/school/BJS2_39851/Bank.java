package school.BJS2_39851;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

public class Bank {

    private ConcurrentHashMap<Integer, Account> accounts = new ConcurrentHashMap<>();

    public boolean transfer(int fromAccountId, int toAccountId, double amount) {
        if (checkConditions(fromAccountId, toAccountId)) {
            ReentrantLock lockFromAccount = accounts.get(fromAccountId).getLock();
            ReentrantLock lockToAccount = accounts.get(fromAccountId).getLock();
            ReentrantLock lock1 = fromAccountId > toAccountId ? lockFromAccount : lockToAccount;
            ReentrantLock lock2 = fromAccountId > toAccountId ? lockToAccount : lockFromAccount;
            Account fromAccount = accounts.get(fromAccountId);
            Account toAccount = accounts.get(toAccountId);
            synchronized (lock1) {
                synchronized (lock2) {
                    double sumFromAccount = accounts.get(fromAccountId).getBalance();
                    if (sumFromAccount < amount) {
                        System.out.println("Недостаточно средств для перевода");
                        return false;
                    }
                    fromAccount.withdraw(amount);
                    toAccount.deposit(amount);
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkConditions(int fromAccountId, int toAccountId) {
        if (!accounts.containsKey(fromAccountId)) {
            System.out.println("Отсутствует аккаунт для исходящего перевода");
            return false;
        } else if (!accounts.containsKey(toAccountId)) {
            System.out.println("Отсутствует аккаунт принимающий перевод");
            return false;
        }
        return true;
    }

    public double getTotalBalance() {
        return accounts.values().stream().mapToDouble(Account::getBalance).sum();
    }

    public void addAccounts(int id, Account account) {
        accounts.put(id, account);
    }
}
