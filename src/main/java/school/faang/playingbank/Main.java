package school.faang.playingbank;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static final ExecutorService EXECUTOR =
            Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
    private static final Bank BANK = new Bank();
    private static final int COUNT_ACCOUNTS = 10;
    private static final int COUNT_OPERATIONS = 100;
    private static final List<CompletableFuture<Void>> FUTURES = new ArrayList<>();
    private static final Random RANDOM = new Random();
    private static final int MAX_AMOUNT = 1500;
    private static final int MIN_AMOUNT = 500;
    private static final int DEPOSIT_AMOUNT = 5000;
    private static final int TIME_EXECUTION = 10;
    private static final TimeUnit TIME_UNIT = TimeUnit.SECONDS;

    public static void main(String[] args) {
        for (int i = 0; i < COUNT_ACCOUNTS; i++) {
            Account account = new Account();
            BANK.addAccount(account);
            account.replenishAccountBalance(DEPOSIT_AMOUNT);
        }

        for (int i = 0; i < COUNT_OPERATIONS; i++) {
            FUTURES.add(CompletableFuture.runAsync(() -> {
                int countAccounts = BANK.getAccounts().size();
                int fromAccountId = 1 + RANDOM.nextInt(countAccounts);
                int toAccountId = 1 + RANDOM.nextInt(countAccounts);
                if (fromAccountId == toAccountId) {
                    if (fromAccountId == BANK.getAccounts().size()) {
                        fromAccountId--;
                    } else {
                        fromAccountId++;
                    }
                }
                int amount = MIN_AMOUNT + (int) (Math.random() * (MAX_AMOUNT - MIN_AMOUNT + 1));
                BANK.transfer(fromAccountId, toAccountId, amount);
            }, EXECUTOR));
        }
        CompletableFuture.allOf(FUTURES.toArray(CompletableFuture[]::new)).join();
        EXECUTOR.shutdown();

        try {
            if (EXECUTOR.awaitTermination(TIME_EXECUTION, TIME_UNIT)) {
                BANK.getTotalBalance();
                BANK.getAccounts().values().forEach(account ->
                        log.info("Id: {}, balance: {}", account.getId(), account.getBalance()));
            } else {
                log.warn("Execution timed out {} {}", TIME_EXECUTION, TIME_UNIT);
                EXECUTOR.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("Thread was interrupted. Thread name: {}\nException: {}\n{}",
                    Thread.currentThread().getName(), e, e.getStackTrace());
            Thread.currentThread().interrupt();
            EXECUTOR.shutdownNow();
        }
    }
}
