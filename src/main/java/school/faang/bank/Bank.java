package school.faang.bank;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public class Bank {
    private final Map<Integer, Account> accounts = new HashMap<>();

    public void createAccount(Account account) {
        accounts.put(account.getId(), account);
    }

    public void transfer(int fromAccountId, int toAccountId, double amount) {
        Account from = accounts.get(fromAccountId);
        Account to = accounts.get(toAccountId);
        Account lockFrom;
        Account lockTo;

        if (fromAccountId == toAccountId) {
            lockFrom = from;
            lockTo = lockFrom;
        } else {
            lockFrom = fromAccountId > toAccountId ? from : to;
            lockTo = fromAccountId > toAccountId ? to : from;
            lockFrom.getLock().lock();
            lockTo.getLock().lock();
        }
        boolean isWithdraw = from.withdraw(amount);

        try {
            if (isWithdraw) {
                to.deposit(amount);
                System.out.printf("перевод выполнен на %d\n", to.getId());
            }
        } finally {
            lockFrom.getLock().unlock();
            lockTo.getLock().unlock();
        }
    }

    public double getTotalBalance() {
        return accounts.values().stream()
                .mapToDouble(Account::getBalance)
                .sum();
    }
}
