package play_in_bank;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
@AllArgsConstructor
public class Bank {
    private ConcurrentHashMap<Integer, Account> accounts;

    public boolean transfer(int fromAccountId, int toAccountId, double amount) {
        if (!accounts.containsKey(fromAccountId) || !accounts.containsKey(toAccountId)) {
            log.error("One of accounts doesn't exist");
            throw new IllegalArgumentException("Inexistent account");
        }

        if (Objects.isNull(accounts.get(fromAccountId))
                || Objects.isNull(accounts.get(toAccountId))) {
            log.error("One account is null!");
            throw new IllegalArgumentException("Null account!");
        }

        try {
            accounts.get(fromAccountId).withdraw(amount);
        } catch (IllegalArgumentException e) {
            log.error("The operation is failed {}", e.getMessage());
            return false;
        }
        try {
            accounts.get(toAccountId).deposit(amount);
            return true;
        } catch (IllegalArgumentException e) {
            log.error("The operation is failed {}", e.getMessage());
            accounts.get(fromAccountId).deposit(amount);
            return false;
        }
    }

    public double getTotalBalance() {
        return accounts.entrySet().stream()
                .mapToDouble(entry -> entry.getValue().getBalance())
                .sum();
    }
}
