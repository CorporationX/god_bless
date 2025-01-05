package derschrank.sprint04.task18.bjstwo_51046;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.DoubleAccumulator;
import java.util.concurrent.atomic.DoubleAdder;
import java.util.concurrent.locks.Lock;

public class Bank {
    private static final int PRINT_ACCOUNTS_IN_ROW = 10;
    private final Map<Integer, Account> accounts;

    public Bank() {
        accounts = new ConcurrentHashMap<>();
    }

    public synchronized void addAccount(Account account) {
        accounts.put(account.id(), account);
    }

    public boolean transfer(int fromAccountId, int toAccountId, double amount) {
        Account fromAccount = accounts.get(fromAccountId);
        if (fromAccount == null) {
            System.out.println("Account FROM is not found by: " + fromAccountId);
            return false;
        }
        Account toAccount = accounts.get(toAccountId);
        if (toAccount == null) {
            System.out.println("Account TO is not found by: " + toAccountId);
            return false;
        }
        if (fromAccount.withdraw(amount)) {
            toAccount.deposit(amount);
            System.out.printf("The transfer %f was successfully completed from the account %d to the account %d%n",
                    amount,
                    fromAccount.id(),
                    toAccount.id());
            return true;
        } else {
            System.out.println("Insufficient funds: " + amount);
            return false;
        }
    }

    public double getTotalBalance() {
        DoubleAdder total = new DoubleAdder();
        accounts.values().forEach(account ->
            total.add(account.getBalance())
        );
        return total.doubleValue();
    }

    public void printAllAccounts() {
        List<Account> accountsList;
        synchronized (this) {
            accountsList = new ArrayList<>(accounts.values());
        }
        for (int i = 0; i < accountsList.size(); i++) {
            System.out.print(accountsList.get(i) + " | ");
            if (i % PRINT_ACCOUNTS_IN_ROW == 0) {
                System.out.print("\n");
            }
        }
        if ((accountsList.size() - 1) % PRINT_ACCOUNTS_IN_ROW != 0) {
            System.out.print("\n");
        }
    }
}
