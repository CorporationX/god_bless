package school.faang.task51037;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

@Slf4j
public class Bank {

    private final Map<Integer, Account> accounts = new HashMap<>();
    private final ReadWriteLock lockAccount = new ReentrantReadWriteLock();

    private void validateAndLockAccount(Account account, Runnable check) {
        Objects.requireNonNull(account);
        lockAccount.writeLock().lock();

        try {
            check.run();
        } catch (IllegalArgumentException e) {
            log.error(e.getMessage(), e);
        } finally {
            lockAccount.writeLock().unlock();
        }
    }

    public void addAccount(Account account) {
        validateAndLockAccount(account, () -> {
            accounts.putIfAbsent(account.getId(), account);
            log.info("Добавлен новый аккаунт: {}", account);
        });
    }

    public void removeAccount(Account account) {
        validateAndLockAccount(account, () -> {
            if (accounts.keySet().remove(account.getId())) {
                log.info("{} удалён", account);
            } else {
                throw new IllegalArgumentException("Не удалось удалить аккаунт");
            }
        });
    }

    public boolean transfer(int fromAccountId, int accountId, double amount) {

        Account account1 = accounts.get(fromAccountId);
        Account account2 = accounts.get(accountId);

        Objects.requireNonNull(account1);
        Objects.requireNonNull(account2);

        Account firstLock = fromAccountId < accountId ? account1 : account2;
        Account secondLock = fromAccountId < accountId ? account2 : account1;

        firstLock.getLock().lock();
        secondLock.getLock().lock();


        try {
            if (fromAccountId == accountId) {
                throw new IllegalArgumentException("Нельзя произвести трансфер на тот же счёт");
            }
            if (amount <= 0) {
                throw new IllegalArgumentException(String.format("%f не может быть меньше либо равно 0", amount));
            }
            if (accounts.containsKey(fromAccountId) && accounts.containsKey(accountId)) {


                account1.withdraw(amount);
                account2.deposit(amount);

                log.info("Произведён трансфер со счёта {} на счёт {} суммой {}", fromAccountId, accountId, amount);

                return true;
            } else {
                throw new IllegalArgumentException("Проблема с id");
            }
        } catch (IllegalArgumentException e) {
            log.error(e.getMessage(), e);
            return false;
        } finally {
            secondLock.getLock().unlock();
            firstLock.getLock().unlock();
        }
    }

    public double getTotalBalance() {
        lockAccount.readLock().lock();

        try {
            double total = accounts.values().stream().mapToDouble(Account::getBalance).sum();
            log.info("Общий баланс {}", total);
            return total;
        } finally {
            lockAccount.readLock().unlock();
        }
    }
}
