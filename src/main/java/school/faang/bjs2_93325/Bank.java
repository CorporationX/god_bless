package school.faang.bjs2_93325;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicReference;

@Getter
@Slf4j
public class Bank {
    private Map<Integer, Account> accounts = new ConcurrentHashMap();
    private final AtomicReference<Double> totalBalance = new AtomicReference<>(0.0);

    public void addAccount(Account account) {
        accounts.put(account.getId(), account);
    }

    public boolean transfer(int fromAccountId, int toAccountId, double amount) {
        Account accountStart = accounts.get(fromAccountId);
        Account accountFinish = accounts.get(toAccountId);

        if (accountStart.getBalance() >= amount) {
            accountStart.withdraw(amount);
            accountFinish.deposit(amount);
            log.info("Был сделан перевод со счета {} на счет {}", accountStart, accountFinish);
            return true;
        } else {
            log.info("На счет {} не хватает денег");
            return false;
        }
    }

    public double getTotalBalance() {
        totalBalance.updateAndGet(d -> sumBalance());
        log.info("Получена общий баланс банка {}", totalBalance.get());
        return totalBalance.get();
    }

    private double sumBalance() {
        return accounts.values().stream()
                .mapToDouble(account -> account.getBalance())
                .sum();
    }
}
