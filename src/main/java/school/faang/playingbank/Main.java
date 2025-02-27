package school.faang.playingbank;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static final ExecutorService EXECUTOR =
            Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
    private static final Bank BANK = new Bank();
    private static final int COUNT_ACCOUNTS = 10;
    private static final int COUNT_OPERATIONS = 1000;
    private static final List<CompletableFuture<Void>> FUTURES = new ArrayList<>();
    private static final Random RANDOM = new Random();
    private static final int MAX_AMOUNT = 1500;
    private static final int MIN_AMOUNT = 500;
    private static final int DEPOSIT_AMOUNT = 5000;
    private static final int TIME_EXECUTION = 1;
    private static final TimeUnit TIME_UNIT = TimeUnit.MINUTES;

    public static void main(String[] args) {
        try {
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
                }, EXECUTOR).orTimeout(TIME_EXECUTION, TIME_UNIT));
            }
            CompletableFuture.allOf(FUTURES.toArray(CompletableFuture[]::new)).join();
            BANK.getTotalBalance();
            BANK.getAccounts().values().forEach(account ->
                    log.info("Id: {}, balance: {}", account.getId(), account.getBalance()));

            EXECUTOR.shutdown();
        } catch (CompletionException e) {
            log.error("Timed out {} {}", TIME_EXECUTION, TIME_UNIT);
            EXECUTOR.shutdownNow();
        }
    }
}
