package school.faang.multithreading.concurr.bank;

import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

@Slf4j
public class Main {
    private static final Random random = new Random();
    private static final int THREADS_COUNT = 4;
    private static final ExecutorService executor = Executors.newFixedThreadPool(THREADS_COUNT);

    public static void main(String[] args) {
        Bank bank = new Bank();

        List<Account> accounts = List.of(
                new Account(1, BigDecimal.valueOf(100000)),
                new Account(2, BigDecimal.valueOf(200000)),
                new Account(3, BigDecimal.valueOf(300000)),
                new Account(4, BigDecimal.valueOf(400000)),
                new Account(5, BigDecimal.valueOf(500000))
        );
        accounts.forEach(bank::addAccount);

        IntStream.range(0, THREADS_COUNT)
                .mapToObj(i -> (Runnable) () -> {
                    for (int j = 0; j < 10; j++) {
                        int fromAccountId = random.nextInt(5) + 1;
                        int toAccountId = random.nextInt(5) + 1;
                        BigDecimal amount = BigDecimal.valueOf(random.nextInt(50000));

                        if (fromAccountId != toAccountId) {
                            bank.transfer(fromAccountId, toAccountId, amount);
                        }
                    }
                })
                .forEach(executor::submit);

        shutdown();
        awaitTermination();
        log.info("Общий баланс:{}", bank.getTotalBalance());
    }

    private static void shutdown() {
        executor.shutdown();
    }

    private static void awaitTermination() {
        try {
            if (!executor.awaitTermination(1, TimeUnit.MINUTES)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
