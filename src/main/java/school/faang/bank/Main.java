package school.faang.bank;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        Account account1 = new Account(1, 100.0);
        Account account2 = new Account(2, 400.0);
        Account account3 = new Account(3, 750.0);
        Account account4 = new Account(4, 50.0);
        Account account5 = new Account(5, 240.0);

        Bank bank = new Bank();
        bank.createAccount(account1);
        bank.createAccount(account2);
        bank.createAccount(account3);
        bank.createAccount(account4);
        bank.createAccount(account5);

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        Runnable runnable = () -> {
            Random random = new Random();
            for (int i = 0; i < 10; i++) {
                int fromAccountId = random.nextInt(4) + 1;
                int toAccountId = random.nextInt(4) + 1;
                double amount = random.nextInt(300);

                if (fromAccountId != toAccountId) {
                    bank.transfer(fromAccountId, toAccountId, amount);
                }
            }
        };
        IntStream.range(0, 3)
                .forEach(i -> {
                    executorService.submit(runnable);
                });
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(2, TimeUnit.MINUTES)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
        }

        System.out.println("Total amount " + bank.getTotalBalance());
    }
}
