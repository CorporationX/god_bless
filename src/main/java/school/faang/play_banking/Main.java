package school.faang.play_banking;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

@Slf4j
public class Main {
    private static final int THREAD_AMOUNT = 5;

    public static void main(String[] args) {
        Bank bank = new Bank();
        List<Account> accounts = List.of(
                new Account(1, 1000.0),
                new Account(2, 2000.0),
                new Account(3, 3000.0),
                new Account(4, 4000.0)
        );

        accounts.forEach(bank::addAccount);

        ExecutorService executor = Executors.newFixedThreadPool(THREAD_AMOUNT);
        Runnable task = () -> {
            Random random = new Random();
            IntStream.range(1, 10)
                    .forEach(i -> {
                        int fromAccountId = random.nextInt(4) + 2;
                        int toAccountId = random.nextInt(4) + 1;
                        double amount = random.nextInt(i * 300);

                        if (fromAccountId != toAccountId) {
                            boolean transferStatus = bank.transfer(fromAccountId, toAccountId, amount);
                            if (!transferStatus) {
                                log.info("Money transfer cancelled");
                            }
                        }
                    });
        };

        IntStream.range(0, THREAD_AMOUNT)
                .forEach(i -> executor.submit(task));

        executor.shutdown();
        try {
            if (executor.awaitTermination(3, TimeUnit.SECONDS)) {
                log.info("Transfer process complete");
            } else {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("Tasks completed with errors {}", e.getMessage());
        }

        log.info("Total balance: {}", bank.getTotalBalance());
    }
}
