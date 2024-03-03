package faang.school.godbless.bank;

import lombok.Getter;

import java.math.BigDecimal;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Getter
public class Bank {

    private Map<Integer, Account> accounts = new ConcurrentHashMap<>();

    public boolean transfer(Account from, Account to, BigDecimal amount) {
        if (!isEnoughFunds(from, amount)) {
            return false;
        }
        if (from.getId() < to.getId()) {
            from.getLOCK().lock();
            to.getLOCK().lock();
        }
        else {
            to.getLOCK().lock();
            from.getLOCK().lock();
        }
        try {
            from.withdraw(amount);
            to.deposit(amount);
            return true;
        } finally {
            from.getLOCK().unlock();
            to.getLOCK().unlock();
        }
    }

    public BigDecimal getTotalBalance() {
        return accounts.values().stream()
                .map(Account::getBalance)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public void addAccount(Account account) {
        accounts.put(account.getId(), account);
    }

    private boolean isEnoughFunds(Account from, BigDecimal amount) {
        return from.getBalance().compareTo(amount) >= 0;
    }
}
