package faang.school.godbless.BJS2_25261;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static final int NUM_ACCOUNTS = 10;
    private static ExecutorService executorService = Executors.newFixedThreadPool(5);

    public static void main(String[] args) {
        Bank bank = new Bank();

        for (int i = 0; i < NUM_ACCOUNTS; i++) {
            bank.addAccount(i);
        }

        System.out.println(bank.getAccounts());
        log.info("Balance before transfers = {}", bank.getTotalBalance());

        for (int i = 0; i < 5; i++) {
            executorService.execute(() -> bank.transfer(bank.getRandomAccount(),
                    bank.getRandomAccount(),
                    ThreadLocalRandom.current().nextInt(500)));
        }

        executorService.shutdown();
        try {
            executorService.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(bank.getAccounts());
        log.info("Balance after transfers = {}", bank.getTotalBalance());
    }
}
