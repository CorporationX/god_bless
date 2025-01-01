package school.faang.sprint4.task_51056;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
@RequiredArgsConstructor
public class Bank {
    private final Map<Integer, Account> accounts = new ConcurrentHashMap<>();

    public boolean transfer(int fromAccountId, int toAccountId, double amount) {
        Account sender = Optional.ofNullable(accounts.get(fromAccountId))
                .orElseThrow(() -> new IllegalArgumentException("There is no account with id: " + fromAccountId));
        Account receiver = Optional.of(accounts.get(toAccountId))
                .orElseThrow(() -> new IllegalArgumentException("There is no account with id " + toAccountId));

        Account firstLock;
        Account secondLock;

        if (sender.getId() > receiver.getId()) {
            firstLock = receiver;
            secondLock = sender;
        } else {
            firstLock = sender;
            secondLock = receiver;
        }

        synchronized (firstLock) {
            if (firstLock.withdraw(amount)) {
                log.info("Transfer error, not enough money. Sender balance: {}. Transfer amount: {}",
                        firstLock.getBalance(), amount);
                return false;
            }

            synchronized (secondLock) {
                secondLock.deposit(amount);
                log.info("Transferred {} from account with id = {}. To account with id = {}",
                        amount, fromAccountId, toAccountId);
            }
        }
        return true;
    }

    public void addAccount(Account account) {
        accounts.put(account.getId(), account);
    }

    public double getTotalBalance() {
        return accounts.values()
                .stream().mapToDouble(Account::getBalance)
                .sum();
    }
}
