package faang.school.godbless.BJS2_25303;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Map;

@Getter
@AllArgsConstructor
public class Bank {
    private final Map<Integer, Account> accounts;

    public boolean transfer(Account from, Account to, int amount) {
        if (from.getBalance() < amount) {
            return false;
        }
        if (from.getId() < 0 || to.getId() < 0) {
            synchronized (from) {
                synchronized (to) {
                    from.withdraw(amount);
                    to.deposit(amount);
                }
            }
        }
        return true;
    }

    public Long getTotalBalance() {
        synchronized (accounts) {
            return accounts.values().stream()
                    .mapToLong(Account::getBalance).sum();
        }
    }
}
