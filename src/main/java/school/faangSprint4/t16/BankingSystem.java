package school.faangSprint4.t16;

import java.util.Random;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BankingSystem {
    private static final int SLEEP_TIME = 100;
    private static final int NUMBER_OF_THREADS = 3;
    private static final int NUMBER_OF_TRANSFERS = 5;
    private static final double MAX_TRANSFER_AMOUNT = 500.0;
    private static final int MAX_SHUTDOWN_WAIT_SECONDS = 60;

    private static final int MIN_ACCOUNT_ID = 1;
    private static final int MAX_ACCOUNT_ID = 3;


    private static final Map<Integer, Double> INITIAL_ACCOUNTS = Map.of(
            1, 1000.0,
            2, 2000.0,
            3, 1500.0
    );

    public static void main(String[] args) {
        Bank bank = new Bank();

        INITIAL_ACCOUNTS.forEach((id, balance) ->
                bank.addAccount(new Account(id, balance))
        );

        Runnable transferTask = () -> {
            Random random = new Random();
            for (int i = 0; i < NUMBER_OF_TRANSFERS; i++) {
                int fromAccount = random.nextInt(MAX_ACCOUNT_ID) + MIN_ACCOUNT_ID;
                int toAccount;
                do {
                    toAccount = random.nextInt(MAX_ACCOUNT_ID) + MIN_ACCOUNT_ID;
                } while (toAccount == fromAccount);

                double amount = random.nextDouble() * MAX_TRANSFER_AMOUNT;
                boolean success = bank.transfer(fromAccount, toAccount, amount);

                System.out.printf("Thread %s: Transfer %.2f from Account %d to Account %d - %s%n",
                        Thread.currentThread().getName(),
                        amount,
                        fromAccount,
                        toAccount,
                        success ? "SUCCESS" : "FAILED (Insufficient funds)");

                try {
                    Thread.sleep(SLEEP_TIME);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        };

        ExecutorService executor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

        for (int i = 0; i < NUMBER_OF_THREADS; i++) {
            executor.submit(transferTask);
        }

        executor.shutdown();
        try {
            if (!executor.awaitTermination(MAX_SHUTDOWN_WAIT_SECONDS, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }

        System.out.printf("%nFinal total balance: %.2f%n", bank.getTotalBalance());
    }
}