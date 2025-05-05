package school.faang.sprint4_concurrency.playinthebank;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@AllArgsConstructor
@Slf4j
public class Bank {
    private final Map<Integer, Account> accounts = new ConcurrentHashMap<>();

    public void addAccount(Map<Integer, Account> account) {
        accounts.putAll(account);
    }

    public boolean transfer(int fromAccountId, int toAccountId, double amount) {
        if (fromAccountId == toAccountId) {
            log.warn("Нельзя переводить на свой счет!!!!");
            return false;
        }

        Account from = accounts.get(fromAccountId);
        Account to = accounts.get(toAccountId);

        if (from == null || to == null) {
            log.warn("один из счетов не найден!!!");
            return false;
        }

        Account firstLock = fromAccountId < toAccountId ? from : to;
        Account secondLock = fromAccountId < toAccountId ? to : from;

        firstLock.getLock().lock();
        try {
            secondLock.getLock().lock();
            if (from.withdraw(amount)) {
                to.deposit(amount);
                return true;
            } else {
                log.warn("Ошибка. Что-то ввели не то.");
                return false;
            }

        } finally {
            secondLock.getLock().unlock();
            firstLock.getLock().unlock();
        }
    }

    public double getTotalBalance() {
        return accounts.values().stream()
                .mapToDouble(Account::getBalance)
                .sum();
    }
}