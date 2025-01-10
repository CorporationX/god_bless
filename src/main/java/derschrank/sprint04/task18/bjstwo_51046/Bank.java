package derschrank.sprint04.task18.bjstwo_51046;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.DoubleAdder;

public class Bank {
    private static final int AWAIT_FOR_TRY_LOCK_MILLIS = 100;
    private static final int PRINT_ACCOUNTS_IN_ROW = 10;
    private final Map<Integer, Account> accounts;

    public Bank() {
        accounts = new ConcurrentHashMap<>();
    }

    public void addAccount(Account account) {
        accounts.put(account.id(), account);
    }

    public boolean transfer(int fromAccountId, int toAccountId, double amount) {
        if (!validateTransfer(fromAccountId, toAccountId)) {
            return false;
        }

        Account fromAccount = accounts.get(fromAccountId);
        Account toAccount = accounts.get(toAccountId);
        while (true) {
            if (fromAccount.lock().tryLock()) {
                try {
                    if (toAccount.lock().tryLock()) {
                        try {
                            if (fromAccount.withdraw(amount)) {
                                toAccount.deposit(amount);
                                printSuccessTransfer(amount, fromAccountId, toAccountId);
                                return true;
                            } else {
                                printNotSuccessTransfer(amount);
                                return false;
                            }
                        } finally {
                            toAccount.lock().unlock();
                        }
                    }
                } finally {
                    fromAccount.lock().unlock();
                }
            }
            delayToTry(AWAIT_FOR_TRY_LOCK_MILLIS);
        }
    }

    private boolean validateTransfer(int fromAccountId, int toAccountId) {
        if (fromAccountId == toAccountId) {
            System.out.println("Transfer from one account to the same account is not possible: " + fromAccountId);
            return false;
        }
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
        return true;
    }

    public double getTotalBalance() {
        DoubleAdder total = new DoubleAdder();
        accounts.values().forEach(account ->
                total.add(account.getBalance())
        );
        return total.doubleValue();
    }

    public void printAllAccounts() {
        List<Account> accountsList = new ArrayList<>(accounts.values());
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

    private void delayToTry(int delay) {
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            System.out.println("Deposit was interrupted: " + e);
            Thread.currentThread().interrupt();
        }
    }

    private static void printSuccessTransfer(double amount, int fromAccountId, int toAccountId) {
        System.out.printf("The transfer %f was successfully completed from the account %d to the account %d%n",
                amount,
                fromAccountId,
                toAccountId);
    }

    private static void printNotSuccessTransfer(double amount) {
        System.out.println("Insufficient funds: " + amount);
    }
}
