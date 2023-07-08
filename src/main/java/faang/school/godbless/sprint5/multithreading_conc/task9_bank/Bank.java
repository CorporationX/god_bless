package faang.school.godbless.sprint5.multithreading_conc.task9_bank;

import java.util.concurrent.ConcurrentHashMap;

public class Bank {
    private final ConcurrentHashMap<Integer, Account> accounts;

    public Bank() {
        this.accounts = new ConcurrentHashMap<>();
    }

    public void addAccount(Account account) {
        accounts.put(account.getId(), account);
    }

    public boolean transfer(Account from, Account to, int amount) {
        if (from.equals(to)) {
            throw new IllegalArgumentException("Нельзя переводить с самого себя");
        }
        if (from.getBalance() < amount) {
            System.out.println("На аккаунте №" + from.getId() + " недостаточно средств");
            return false;
        }
        from.withdraw(amount);
        to.deposit(amount);
        System.out.println("С аккаунта № " + from.getId() + " на аккаунт № " + to.getId() + " сумма " + amount + " успешно переведена");
        return true;

    }

    public int getTotalBalance() {
         int totalBalance = accounts.values().stream()
                .mapToInt(Account::getBalance)
                .sum();
        System.out.println(" Общий баланс в банке: " + totalBalance);
        return totalBalance;
    }
}
