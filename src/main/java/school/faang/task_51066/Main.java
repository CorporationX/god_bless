package school.faang.task_51066;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

@Slf4j
public class Main {
    private static final int NUM_THREADS = 5;
    private static final int TERMINATION_TIMEOUT = 30;

    public static void main(String[] args) {
        UUID firstRandomId = UUID.randomUUID();
        UUID secondRandomId = UUID.randomUUID();
        UUID thirdRandomId = UUID.randomUUID();

        Bank bank = setUpBank(firstRandomId, secondRandomId, thirdRandomId);

        ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);

        IntStream.range(0, NUM_THREADS).forEach(num -> {
            executorService.execute(() -> {
                bank.transfer(firstRandomId, secondRandomId, 100);
            });
        });

        executorService.shutdown();
        try {
            if (executorService.awaitTermination(TERMINATION_TIMEOUT, TimeUnit.SECONDS)) {
                log.info("Total balance: {}", bank.getTotalBalance());
                log.info("All tasks completed successfully");
            } else {
                log.error("Tasks are not completed");
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error(e.getMessage());
        }
    }

    private static Bank setUpBank(UUID firstRandomId, UUID secondRandomId, UUID thirdRandomId) {
        Random random = new Random();

        Account firstAccount = new Account(firstRandomId);
        firstAccount.setBalance(random.nextDouble(1000));
        Account secondAccount = new Account(secondRandomId);
        secondAccount.setBalance(random.nextDouble(1000));
        Account thirdAccount = new Account(thirdRandomId);
        thirdAccount.setBalance(random.nextDouble(1000));

        Bank bank = new Bank();
        bank.addAccount(firstAccount);
        bank.addAccount(secondAccount);
        bank.addAccount(thirdAccount);

        return bank;
    }
}
