package school.faang.bank_game;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.Objects;

@Slf4j
@AllArgsConstructor
public class Bank {
    private Map<Integer, Account> accounts;

    public synchronized boolean transfer(int fromAccountId, int toAccountId, double amount) {
        if (!accounts.containsKey(fromAccountId) || !accounts.containsKey(toAccountId)) {
            log.error("Account {} or {} does not exist", fromAccountId, toAccountId);
            return false;
        }
        Objects.requireNonNull(accounts.get(fromAccountId), "Account " + fromAccountId + " does not exist");
        Objects.requireNonNull(accounts.get(toAccountId), "Account " + toAccountId + " does not exist");

        try {
            accounts.get(fromAccountId).withdraw(amount);
            accounts.get(toAccountId).deposit(amount);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public double getTotalBalance() {
        return accounts.values().stream().mapToDouble(Account::getBalance).sum();
    }
}
