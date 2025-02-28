package school.faang.playingbank;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static final ExecutorService EXECUTOR =
            Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
    private static final Bank BANK = new Bank();
    private static final int COUNT_ACCOUNTS = 10;
    private static final int COUNT_OPERATIONS = 1000;
    private static final List<CompletableFuture<Void>> FUTURES = new ArrayList<>();
    private static final int MAX_AMOUNT = 1500;
    private static final int MIN_AMOUNT = 500;
    private static final int DEPOSIT_AMOUNT = 5000;
    private static final int TIME_EXECUTION = 1;
    private static final TimeUnit TIME_UNIT = TimeUnit.MINUTES;
    private static final List<String> NAMES = List.of(
            "Max", "Oleg", "Alina", "Darya", "Svetlana", "Artem", "Sergey", "Aleksey", "Regina", "Liana"
    );

    public static void main(String[] args) {
        try {
            for (int i = 0; i < COUNT_ACCOUNTS; i++) {
                Account account = new Account(NAMES.get(i));
                BANK.addAccount(account);
                account.replenishAccountBalance(DEPOSIT_AMOUNT);
            }

            for (int i = 0; i < COUNT_OPERATIONS; i++) {
                FUTURES.add(CompletableFuture.runAsync(() -> {
                    List<UUID> keys = new ArrayList<>(BANK.getAccounts().keySet());
                    UUID fromAccountId = keys.get(ThreadLocalRandom.current().nextInt(keys.size()));
                    UUID toAccountId = keys.get(ThreadLocalRandom.current().nextInt(keys.size()));
                    while (fromAccountId.equals(toAccountId)) {
                        toAccountId = keys.get(ThreadLocalRandom.current().nextInt(keys.size()));
                    }
                    int amount = MIN_AMOUNT + (int) (Math.random() * (MAX_AMOUNT - MIN_AMOUNT + 1));
                    BANK.transfer(fromAccountId, toAccountId, amount);
                }, EXECUTOR).orTimeout(TIME_EXECUTION, TIME_UNIT));
            }
            CompletableFuture.allOf(FUTURES.toArray(CompletableFuture[]::new)).join();
            BANK.getTotalBalance();
            BANK.getAccounts().values().forEach(account ->
                    log.info("Name: {}, balance: {}", account.getName(), account.getBalance()));

            EXECUTOR.shutdown();
        } catch (CompletionException e) {
            log.error("Timed out {} {}", TIME_EXECUTION, TIME_UNIT);
            EXECUTOR.shutdownNow();
        }
    }
}
