package school.faang.playbank;

import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
public class Bank {
    private final Map<Integer, Account> accounts = new ConcurrentHashMap<>();

    public void addAccount(Account account) {
        accounts.put(account.getId(), account);
    }

    public boolean transfer(int fromAccountId, int toAccountId, double amount) {
        Account fromAccount = accounts.get(fromAccountId);
        Account toAccount = accounts.get(toAccountId);

        if (fromAccount == null || toAccount == null) {
            log.info("Один из счетов не найден.");
            return false;
        }
        if (fromAccountId == toAccountId) {
            log.info("Одинаковые счета!");
            return false;
        }

        Account firstLock = fromAccountId < toAccountId ? fromAccount : toAccount;
        Account secondLock = fromAccountId < toAccountId ? toAccount : fromAccount;

        firstLock.getLock().lock();
        secondLock.getLock().lock();

        try {
            if (fromAccount.withdraw(amount)) {
                toAccount.deposit(amount);
                log.info("Перевод прошёл успешно! {} руб. перечислено со счёта {} на счёт {}",
                        amount, fromAccountId, toAccountId);
                return true;
            } else {
                log.info("Операция невозможна. Недостаточно средств на счёте {}. Не хватает {} руб.",
                        fromAccountId, String.format("%.2f", amount - fromAccount.getBalance()));
                return false;
            }
        } finally {
            firstLock.getLock().unlock();
            secondLock.getLock().unlock();
        }
    }

    public double getTotalBalance() {
        return accounts.values().stream()
                .mapToDouble(Account::getBalance)
                .sum();
    }
}
