package faang.school.godbless.multi_con.task6bank;

import lombok.Getter;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;

@Getter
public class Bank {
    private final Map<Integer, Account> accounts = new ConcurrentHashMap<>();

    public boolean transfer(int fromId, int toId, double amount) {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.out.println("Банк сломался");
        }

        Account from = accounts.get(fromId);
        Account to = accounts.get(toId);

        Lock firstLock, secondLock;
        if (toId < fromId) {
            firstLock = from.getLock();
            secondLock = to.getLock();
        } else {
            firstLock = to.getLock();
            secondLock = from.getLock();
        }

        firstLock.lock();
        try {
            secondLock.lock();
            try {
                if (from.getBalance() >= amount) {
                    from.withdraw(amount);
                    to.deposit(amount);
                    System.out.printf("Перевод выполнен: с аккаунта %d на аккаунт %d, сумма: %.2f. Баланс отправителя: %.2f. Баланс получателя: %.2f.%n",
                            fromId, toId, amount, from.getBalance(), to.getBalance());
                    return true;
                } else {
                    System.out.printf("Перевод не выполнен: недостаточно средств на аккаунте %d. Требуемая сумма: %.2f. Баланс: %.2f.%n",
                            fromId, amount, from.getBalance());
                    return false;
                }
            } finally {
                secondLock.unlock();
            }
        } finally {
            firstLock.unlock();
        }
    }

    public void addAccount(int id, double initialBalance) {
        accounts.put(id, new Account(id, initialBalance));
    }

    public double getTotalBalance() {
        return accounts.values().stream().mapToDouble(Account::getBalance).sum();
    }
}
