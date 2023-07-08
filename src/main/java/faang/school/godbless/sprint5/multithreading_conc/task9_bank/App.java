package faang.school.godbless.sprint5.multithreading_conc.task9_bank;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class App {

    public static void main(String[] args) throws InterruptedException {
        Account account1 = new Account(1, 1000);
        Account account2 = new Account(2, 2000);
        Account account3 = new Account(3, 400);
        Account account4 = new Account(4, 1500);
        Account account5 = new Account(5, 1700);

        Bank bank = new Bank();
        bank.addAccount(account1);
        bank.addAccount(account2);
        bank.addAccount(account3);
        bank.addAccount(account4);
        bank.addAccount(account5);

        ExecutorService executor = Executors.newFixedThreadPool(2);
        for (int i = 0; i < 1_000_000; i++) {
            executor.execute(() -> bank.transfer(account1, account2, 500));
            executor.execute(() -> bank.transfer(account2, account1, 500));

        }

        executor.shutdown();

        while (!executor.awaitTermination(1, TimeUnit.SECONDS)) {
        }
    }
}
