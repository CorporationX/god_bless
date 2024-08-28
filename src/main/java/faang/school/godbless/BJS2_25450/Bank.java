package faang.school.godbless.BJS2_25450;

import lombok.Getter;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Getter
public class Bank {
    private Map<Integer, Account> accounts = new HashMap<>();

    public boolean transfer(Account from, Account to, int amount) {
        if (from.equals(to)) {
            return false;
        }

        synchronized (from.getLock()) {
            if (from.getBalance() >= amount) {

                synchronized (to.getLock()) {
                    System.out.printf("Перевод! Кому: %s, От кого: %s, Сумма: %d%n", from.getName(), to.getName(), amount);
                    from.withdraw(amount);
                    to.deposit(amount);
                }
                return true;

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
