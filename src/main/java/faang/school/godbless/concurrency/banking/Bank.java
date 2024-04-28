package faang.school.godbless.concurrency.banking;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class Bank {
    private final Map<Integer, Account> accounts = new HashMap<>();

    public void addAccount(@NonNull Account account) {
        accounts.putIfAbsent(account.getId(), account);

        log.info("Added new " + account);
    }

    public synchronized void transfer(int senderId, int recipientId, int diff) {
        try {
            if (!accounts.containsKey(senderId) || !accounts.containsKey(recipientId)) {
                throw new IllegalArgumentException("Cannot transfer between non-existent accounts. (senderId = " + senderId + ", recipientId = " + recipientId + ")");
            }

            if (senderId == recipientId) {
                throw new IllegalArgumentException("Cannot transfer between one account. (senderId = " + senderId + ", recipientId = " + recipientId + ")");
            }


            accounts.get(senderId).withdraw(diff);
            accounts.get(recipientId).deposit(diff);
        } catch (IllegalArgumentException e) {
            log.warn("Transfer (senderId = " + senderId + ", recipientId = " + recipientId + ", transferAmount = " + diff + ") failed. " + e.getMessage());
        }
    }

    public synchronized int getTotalBalance() {
        return accounts.values().stream()
                .map(Account::getBalance)
                .reduce(0, Integer::sum);
    }

    public Map<Integer, Account> getAccounts() {
        return accounts;
    }
}
