package faang.school.godbless.BJS2_25450;

import lombok.Getter;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@Getter
public class Bank {
    private Map<Integer, Account> accounts = new ConcurrentHashMap<>();

    public boolean transfer(Account from, Account to, int amount) {
        if (from.equals(to)) {
            return false;
        }

        Object lock1 = from.getLock();
        Object lock2 = to.getLock();
        if (from.getId() < to.getId()) {
            lock1 = to.getLock();
            lock2 = from.getLock();
        }

        synchronized (lock1) {
            synchronized (lock2) {
                if (from.getBalance() >= amount) {
                    System.out.printf("Перевод! Кому: %s, От кого: %s, Сумма: %d%n", from.getName(), to.getName(), amount);
                    from.withdraw(amount);
                    to.deposit(amount);

                    return true;
                }
            }
        }
        return false;
    }

    public int getTotalBalance() {
        Set<Account> clone = new HashSet<>(accounts.values());
        return clone.stream()
                .mapToInt(Account::getBalance)
                .sum();
    }

    public void putAccount(Integer key, Account value) {
        accounts.put(key, value);
    }
}
