package school.faang.play_bank;

import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
public class Bank {
    private final Map<Integer, Account> accounts = new ConcurrentHashMap<>();

    public void transfer(int fromAccountId, int toAccountId, double amount) {
        Account fromAccount = accounts.get(fromAccountId);
        Account toAccount = accounts.get(toAccountId);

        fromAccount.getLock().lock();
        toAccount.getLock().lock();
        if (fromAccount.getBalance() < amount) {
            log.info("Не достаточно денег на балнсе аккаунта {}", fromAccountId);

        } else {
            fromAccount.withdraw(amount);
            toAccount.deposit(amount);
            log.info("Перевод прошел успешно с аккаунта {} на {}", fromAccountId, toAccountId);
        }

        fromAccount.getLock().unlock();
        toAccount.getLock().unlock();
    }

    public void addAccount(Account... newAccounts) {
        for (Account account : newAccounts) {
            accounts.put(account.getId(), account);
        }
    }
}
