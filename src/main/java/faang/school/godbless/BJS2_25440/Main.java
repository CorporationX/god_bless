package faang.school.godbless.BJS2_25440;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();

        List<Account> accounts = List.of(
                new Account(1),
                new Account(2),
                new Account(3)
        );

        accounts.forEach(bank::addAccount);

        accounts.forEach(account -> {
            if (account.getId() == 1) {
                account.deposit(1000);
            } else if (account.getId() == 2) {
                account.deposit(500);
            } else if (account.getId() == 3) {
                account.deposit(800);
            }
        });

        accounts.forEach(account ->
                System.out.println("Баланс аккаунта " + account.getId() + ": " + account.getBalance())
        );

        List<Thread> threads = List.of(
                new Thread(() -> bank.transfer(1, 2, 300)),
                new Thread(() -> bank.transfer(2, 3, 100)),
                new Thread(() -> bank.transfer(3, 1, 2000))
        );

        threads.forEach(Thread::start);

        threads.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        accounts.forEach(account ->
                System.out.println("Баланс аккаунта " + account.getId() + ": " + account.getBalance())
        );

        System.out.println("Общий баланс: " + bank.getTotalBalance());
    }
}
