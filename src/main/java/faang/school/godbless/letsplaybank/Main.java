package faang.school.godbless.letsplaybank;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static final int NUM_THREADS = 10;

    public static void main(String[] args) {
        Bank bank = new Bank();
        ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);
        Random random = new Random();

        bank.addAccount(new Account(1, 1_000_000));
        bank.addAccount(new Account(2, 1_500_000));
        bank.addAccount(new Account(3, 2_000_000));

        for (int i = 0; i < NUM_THREADS; i++) {
            executorService.execute(() -> {
                int fromId = 1 + random.nextInt(3);
                int toId;
                do {
                    toId = 1 + random.nextInt(3);
                } while (fromId == toId);
                double amount = 1_000_000.0 * random.nextDouble();
                bank.transfer(fromId, toId, amount);
            });
        }
        shutdown(executorService);
        System.out.printf("Total Balance: %s", bank.getTotalBalance());
    }

    private static void shutdown(ExecutorService executorService) {
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(10, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error(e.getMessage());
        }
    }
}