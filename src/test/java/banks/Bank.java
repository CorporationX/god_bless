package banks;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Bank {
    private Map<Integer, Account> accounts;

    public Bank() {
        this.accounts = new ConcurrentHashMap<>();
    }

    public void addAccount(Account account) {
        accounts.put(account.getId(), account);
    }

    public boolean transfer(int fromAccountId, int toAccountId, double amount) {
        if (accounts.get(fromAccountId) == null || accounts.get(toAccountId) == null) {
            System.out.println("One of the accounts was not found");
            return false;
        }
        Account firstLock = fromAccountId < toAccountId ? accounts.get(fromAccountId) : accounts.get(toAccountId);
        Account secondLock = fromAccountId < toAccountId ? accounts.get(toAccountId) : accounts.get(fromAccountId);

        firstLock.getLock().lock();
        secondLock.getLock().lock();
        try {
            if (accounts.get(fromAccountId).withdraw(amount)) {
                accounts.get(toAccountId).deposit(amount);
                System.out.println("Transferred " + amount + " from " + fromAccountId + " id accaunt "
                        + " to " + toAccountId + " id accaunt");
                return true;
            } else {
                System.out.println("Insufficient funds in the account " + accounts.get(fromAccountId));
                return false;
            }
        } finally {
            firstLock.getLock().unlock();
            secondLock.getLock().unlock();
        }
    }

    public double getTotalbalance() {
        double totalBalance = accounts.entrySet().stream()
                .map(Map.Entry::getValue)
                .mapToDouble(Account::getBalance)
                .sum();
        return totalBalance;
    }
}
