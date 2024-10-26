package school.faang.play_bank_BJS2_39832;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Bank {
    private Map<Integer, Account> accounts = new ConcurrentHashMap<>();

    public void addAccount(Account account) {
        accounts.put(account.getId(), account);
    }

    public synchronized boolean transfer(int fromAccount, int toAccount, double amount) {
        if (accounts.get(fromAccount) == null || accounts.get(toAccount) == null) {
            System.out.println("One of accounts doesn't exist");
            return false;
        }
        if (accounts.get(fromAccount).getBalance() >= amount) {
            accounts.get(fromAccount).withdraw(amount);
            accounts.get(toAccount).deposit(amount);
            return true;
        }
        return false;
    }

    public double getTotalBalance() {
        return accounts.values().stream()
                .mapToDouble(Account::getBalance)
                .sum();
    }
}