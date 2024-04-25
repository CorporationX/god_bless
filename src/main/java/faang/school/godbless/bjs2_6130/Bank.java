package faang.school.godbless.bjs2_6130;

import lombok.extern.slf4j.Slf4j;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class Bank {

    private final Map<Integer, Account> accounts = new ConcurrentHashMap<>();
    private static final String CANCEL_TRANSFER_MSG = "Account with ID: {} not found. Transfer cancel";


    // перевод средств с одного аккаунта на другой
    public boolean transfer(int fromId, int toId, int transferSum) {
        // Получить аккаунт из хранилища
        Account from = getAccountById(fromId);
        Account to = getAccountById(toId);
        if (from == null) {
            log.error(CANCEL_TRANSFER_MSG, fromId);
            return false;
        }
        if (to == null) {
            log.error(CANCEL_TRANSFER_MSG, toId);
            return false;
        }
        if (from == to) {
            log.error("Transactions with one account are prohibited");
            return false;
        }

        // Снять деньги с аккаунта from
        from.getLock().lock();
        try {
            // Проверить что на аккаунте from достаточно средств для перевода, если нет то вернуть false
            if (from.getBalance().get() < transferSum) {
                log.error("There are not enough funds on the account balance with ID {} for the transfer from {} to {}. Cancel transaction", fromId, fromId, toId);
                return false;
            }
            log.info("Снятие денег ({}) со счета:  {}", transferSum, fromId);
            from.withdraw(transferSum);

            log.info("Приход денег ({}) на счет:  {}", transferSum, toId);
            to.deposit(transferSum);
        } finally {
            from.getLock().unlock();
        }
        // Если все ок вернуть true
        log.info("Transfer money from account {} to account {} successful", fromId, toId);
        return true;
    }

    public Integer getTotalBalance() {
        synchronized (accounts) {
            return accounts.values().stream()
                    .map(Account::getBalance)
                    .map(AtomicInteger::get)
                    .reduce(0, Integer::sum);
        }
    }

    public void addAccount(Account account) {
        if (accounts.containsKey(account.getId())) {
            log.error("Account with ID: {} already exists in the bank", account.getId());
        } else {
            accounts.put(account.getId(), account);
        }
    }

    public Account getAccountById(int accountId) {
        return accounts.get(accountId);
    }

    public void printAllAccounts() {
        synchronized (accounts) {
            accounts.forEach((key, value) -> System.out.println(key + ": Balance=" + value.getBalance()));
        }
    }
}
