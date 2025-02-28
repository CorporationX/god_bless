package school.faang.playingbank;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Getter
@Slf4j
public class Bank {
    private final Map<UUID, Account> accounts = new ConcurrentHashMap<>();

    public void transfer(UUID fromAccountId, UUID toAccountId, int amount) {
        if (isAccountContainsId(fromAccountId, toAccountId) || isAmountNegative(amount)) {
            return;
        }
        Account fromAccount = accounts.get(fromAccountId);
        Account toAccount = accounts.get(toAccountId);

        if (fromAccount.getBalance() >= amount) {
            fromAccount.withdraw(amount);
            toAccount.deposit(amount);
            log.info("Transfer from {} to {} was successful", fromAccount.getName(), toAccount.getName());
        } else {
            log.warn("The account {} has insufficient funds", fromAccount.getName());
        }
    }

    public void addAccount(Account account) {
        validateAccount(account);
        accounts.put(account.getId(), account);
    }

    public void getTotalBalance() {
        AtomicInteger totalSumAccountsBalance = new AtomicInteger(0);
        log.info("Total balance all accounts is {}", totalSumAccountsBalance.addAndGet(accounts
                .values()
                .stream()
                .mapToInt(Account::getBalance)
                .sum()));
    }

    private void validateAccount(Account account) {
        Objects.requireNonNull(account, "Invalid account value");
    }

    private boolean isAccountContainsId(UUID fromAccountId, UUID toAccountId) {
        if (!accounts.containsKey(fromAccountId)) {
            printNotFoundMessage(fromAccountId);
            return true;
        } else if (!accounts.containsKey(toAccountId)) {
            printNotFoundMessage(toAccountId);
            return true;
        }
        return false;
    }

    private void printNotFoundMessage(UUID id) {
        log.warn("Account {} is not found", id);
    }

    private boolean isAmountNegative(int amount) {
        if (amount < 0) {
            log.warn("The amount {} is negative", amount);
            return true;
        }
        return false;
    }
}
