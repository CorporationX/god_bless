package school.faang;

import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static final int THREAD_POOL_SIZE = 6;
    private static final ExecutorService executor = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
    private static final double MIN_TRANSACTION_AMOUNT = 500;
    private static final double MAX_TRANSACTION_AMOUNT = 1000;
    private static final Random random = new Random();
    private static final int TIMEOUT_SECONDS = 30;

    public static void main(String[] args) {
        Bank bank = new Bank();
        bank.addAccount(new Account(0, BigDecimal.valueOf(10000.90)));
        bank.addAccount(new Account(1, BigDecimal.valueOf(70000.9352)));
        bank.addAccount(new Account(2, BigDecimal.valueOf(15300.231)));
        bank.addAccount(new Account(3, BigDecimal.valueOf(20000)));
        bank.addAccount(new Account(4, BigDecimal.valueOf(130000.51)));

        for (int i = 0; i < 100; ++i) {
            double amount = MIN_TRANSACTION_AMOUNT +
                    Math.random() * (MAX_TRANSACTION_AMOUNT - MIN_TRANSACTION_AMOUNT);
            executor.submit(() -> bank.transfer(random.nextInt(5), random.nextInt(5),
                    BigDecimal.valueOf(amount)));
        }
        executor.shutdown();
        try {
            if (!executor.awaitTermination(TIMEOUT_SECONDS, TimeUnit.SECONDS)) {
                log.warn("Not all tasks have been completed on time.");
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            executor.shutdownNow();
            log.error("awaitTermination was interrupted.");
        }
    }
}
