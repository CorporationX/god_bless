package school.faang.multithreading.concurrency.bjs2_75844.bank;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

@Slf4j
public class Main {
    private static final int ACCOUNT_AMOUNT = 10;
    private static final int THREAD_AMOUNT = 5;

    public static void main(String[] args) {
        Bank bank = new Bank();
        List<Account> accounts = new ArrayList<>();

        IntStream.range(0, ACCOUNT_AMOUNT)
                .forEach((i) -> {
                    double value = Math.round((new Random().nextDouble() * 100000) * 100.0) / 100.0;
                    Account account = new Account(value);
                    bank.addAccount(account);
                    accounts.add(account);
                });

        log.info("Accounts: {}", accounts);
        log.info("Bank total Balance = {} ", bank.getTotalBalance());

        ExecutorService pool = Executors.newFixedThreadPool(THREAD_AMOUNT);

        IntStream.range(0, THREAD_AMOUNT)
                .forEach(i ->
                        pool.submit(() -> {
                            int from = new Random().nextInt(accounts.size());
                            int to = new Random().nextInt(accounts.size());
                            double value = Math.round((new Random().nextDouble() * 10000) * 100.0) / 100.0;
                            try {
                                bank.transfer(accounts.get(from).getId(), accounts.get(to).getId(), value);
                            } catch (RuntimeException e) {
                                log.error(e.getMessage());
                            }
                        }));

        pool.shutdown();

        try {
            if (!pool.awaitTermination(1, TimeUnit.MINUTES)) {
                log.warn("Force Termination.");
                pool.shutdownNow();
            } else {
                log.info("Execution is successfully finished.");
                log.info("Accounts: {}", accounts);
                log.info("Bank total Balance = {} ", bank.getTotalBalance());
            }
        } catch (InterruptedException e) {
            log.error("Force Termination. InterruptedException = {}", e.getMessage());
            pool.shutdownNow();
        }
    }
}
