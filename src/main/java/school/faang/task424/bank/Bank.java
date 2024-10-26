package school.faang.task424.bank;

import school.faang.task424.account.Account;

import java.math.BigDecimal;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Bank {
    private Map<Integer, Account> accounts = new ConcurrentHashMap<>();

    public boolean transfer(int fromAccountId, int toAccountId, BigDecimal amount) {
        Account firstAccount = accounts.get(fromAccountId);
        Account secondAccount = accounts.get(toAccountId);

        if (firstAccount == null || secondAccount == null || fromAccountId == toAccountId) {
            System.out.println("Ошибка аккаунта нет или перевод на свой же счет!");
            return false;
        }

        Account accountOne = firstAccount.getId() > secondAccount.getId() ? firstAccount : secondAccount;
        Account accountTwo = firstAccount.getId() > secondAccount.getId() ? secondAccount : firstAccount;

        synchronized (accountOne) {
            synchronized (accountTwo) {
                if (firstAccount.getBalance().doubleValue() > amount.doubleValue()) {
                    firstAccount.withdraw(amount);
                    secondAccount.deposit(amount);
                    System.out.println("Средства доставлены со счета " + firstAccount.getId() + " На счет " + secondAccount.getId());
                    return true;
                } else {
                    System.out.println("На счете не достаточно средств");
                    return false;
                }
            }
        }
    }

    public double getTotalBalance() {
        return accounts.values().stream()
                .mapToDouble(account -> account
                        .getBalance()
                        .doubleValue())
                .reduce(Double::sum)
                .orElse(0);
    }

    public void addAccount(Account account) {
        accounts.put(account.getId(), account);
    }
}
