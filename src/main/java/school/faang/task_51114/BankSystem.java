package school.faang.task_51114;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BankSystem {
    public static void main(String[] args) {
        Bank bank = new Bank();

        bank.addAccount(new Account(1, 1000));
        bank.addAccount(new Account(2, 2000));
        bank.addAccount(new Account(3, 3000));

        ExecutorService executor = Executors.newFixedThreadPool(3);

        Runnable transferTask1 = () -> bank.transfer(1, 2, 500);
        Runnable transferTask2 = () -> bank.transfer(2, 3, 300);
        Runnable transferTask3 = () -> bank.transfer(3, 1, 700);

        executor.submit(transferTask1);
        executor.submit(transferTask2);
        executor.submit(transferTask3);

        executor.shutdown();
        try {
            if (!executor.awaitTermination(10, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }

        System.out.println("Final total balance: " + bank.getTotalBalance());
    }
}