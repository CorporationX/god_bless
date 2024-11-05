package school.faang.letsPlayBank;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final Random random = new Random();
    private static final int NUM_THREADS = 10;
    private static final int NUM_ACCOUNTS = 100;
    private static final double MIN_AMOUNT = 1000;
    private static final double MAX_AMOUNT = 10000;

    public static void main(String[] args) {
        Bank bank = new Bank();
        List<Account> accounts = new ArrayList<>();
        for (int i = 0; i < NUM_ACCOUNTS; i++) {
            accounts.add(new Account(i, random.nextDouble(MIN_AMOUNT, MAX_AMOUNT)));
            bank.addAccount(accounts.get(i));
        }
        ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);
        for (int i = 0; i < NUM_THREADS; i++) {
            executorService.execute(() -> {
                for (int j = 0; j < 100; j++) {
                    int from = random.nextInt(NUM_ACCOUNTS);
                    int to = random.nextInt(NUM_ACCOUNTS);
                    double amount = random.nextDouble(MIN_AMOUNT, MAX_AMOUNT);
                    if (from != to) {
                        bank.transfer(from, to, amount);
                    }
                }
            });
        }

        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(60, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
            Thread.currentThread().interrupt();
            throw new IllegalStateException("Timeout while waiting for executor service to shutdown");
        }
        System.out.println("All transfers completed, total balance: " + bank.getTotalBalance());
    }
}
