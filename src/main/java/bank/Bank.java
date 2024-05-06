package bank;

import lombok.Getter;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Getter
public class Bank {
    private final Map<Integer, Account> accounts = new ConcurrentHashMap<>();

    public boolean transfer(Account account1, Account account2, double amountOfMoney) {
        checkAccount(account1, account2);
        if (!account1.withdraw(amountOfMoney)) {
            return false;
        }
        account2.deposit(amountOfMoney);
        return true;
    }

    public double getTotalBalance(Account account) {
        return account.getBalance();
    }

    public void addAccount(Account account) {
        if (!accounts.containsKey(account.getId())) {
            accounts.put(account.getId(), account);
        }
    }

    private void checkAccount(Account account1, Account account2) {
        if (account1 == null || account2 == null) {
            throw new NullPointerException("Accounts must be exists");
        }
    }
}
