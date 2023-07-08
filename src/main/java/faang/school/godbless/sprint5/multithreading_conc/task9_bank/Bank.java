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
        if (from.getId() < to.getId()) {
            from.getLock().lock();
            to.getLock().lock();
        } else {
            to.getLock().lock();
            from.getLock().lock();
        }

        try {
            if (from.equals(to)) {
                throw new IllegalArgumentException("Нельзя переводить с самого себя");
            }
            if (from.getBalance().get() < amount) {
                System.out.println("На аккаунте №" + from.getId() + " недостаточно средств");
                return false;
            }
            from.withdraw(amount);
            to.deposit(amount);
            System.out.println("С аккаунта № " + from.getId() + " на аккаунт № " + to.getId() + " сумма " + amount + " успешно переведена." +
                    " " + "Новый баланс аккаунта № " + to.getId() + " равен " + to.getBalance().get() + " и аккаунта № " + from.getId() + " равен " + from.getBalance().get());
            return true;
        } finally {
            from.getLock().unlock();
            to.getLock().unlock();
        }

    }

    public int getTotalBalance() {
         int totalBalance = accounts.values().stream()
                .mapToInt(i -> i.getBalance().get())
                .sum();
        System.out.println(" Общий баланс в банке: " + totalBalance);
        return totalBalance;
    }
}
