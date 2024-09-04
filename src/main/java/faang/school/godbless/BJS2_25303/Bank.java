package faang.school.godbless.BJS2_25303;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Map;

@Getter
@AllArgsConstructor
public class Bank {
    private final Map<Integer, Account> accounts;

    public boolean transfer(Account from, Account to, int amount) {
        System.out.println("Start transfer from " + from.getId() + " to " + to.getId() + " Thread " + Thread.currentThread().getId());
        Object firstLock = Math.min(from.getId(), to.getId());
        Object secondLock = Math.max(from.getId(), to.getId());
        synchronized (firstLock) {
            synchronized (secondLock) {
                if (from.getBalance() < amount) {
                    System.out.println("FALSE");
                    return false;
                }
                from.withdraw(amount);
                to.deposit(amount);
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
