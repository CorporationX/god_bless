package faang.school.godbless.bank;

import lombok.Getter;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Getter
public class Bank {
    private final Map<Integer, Account> accounts = new ConcurrentHashMap<>();

    public void addAccount(Account account) {
        accounts.put(account.getId(), account);
    }

    public boolean transfer(int fromId, int toId, int amount) {
        Account from = accounts.get(fromId);
        Account to = accounts.get(toId);
        if (from == null || to == null) {
            System.out.println("Account not found");
            return false;
        }
        if (from.getBalance() < amount) {
            System.out.println("Insufficient funds");
            return false;
        }
        synchronized (from) {
            synchronized (to) {
                from.withdraw(amount);
                to.deposit(amount);
            }
        }
        return true;
    }
}
