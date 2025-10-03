package school.faang.bjs2_93550;

import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Bank {
    private static final int NUM_THREADS = 5;
    private static final int TIMEOUT_IN_SECONDS = 10;

    private final Map<Long, Account> accounts = new ConcurrentHashMap<>();
    private final ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);

    public CompletableFuture<Account> addAccount(Account newAccount) {
        return CompletableFuture.supplyAsync(() -> accounts.put(newAccount.getId(), newAccount), executorService);
    }

    public void transfer(long fromAccountId, long toAccountId, double amount) {
        CompletableFuture.runAsync(() -> {
            if (fromAccountId == toAccountId) {
                log.warn("Переводы между одинаковыми счетами недоступны");
            } else if (!accounts.containsKey(fromAccountId)) {
                log.error("Аккаунт с ID = {} не существует", fromAccountId);
            } else if (!accounts.containsKey(toAccountId)) {
                log.error("Аккаунт с ID = {} не существует", toAccountId);
            } else {
                Account fromAccount = accounts.get(fromAccountId);
                Account toAccount = accounts.get(toAccountId);
                if (fromAccount.withdraw(amount)) {
                    toAccount.deposit(amount);
                }
            }
        }, executorService);
    }

    public double getTotalBalance() throws InterruptedException, ExecutionException {
        return CompletableFuture.supplyAsync(() ->
                accounts.values().stream()
                        .mapToDouble(Account::getBalance)
                        .sum(), executorService).get();
    }

    public void shutdownCorrectly() {
        executorService.shutdown();
        try {
            if (executorService.awaitTermination(TIMEOUT_IN_SECONDS, TimeUnit.SECONDS)) {
                log.info("Все задачи выполнены");
            } else {
                log.info("Задачи не успели выполниться");
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.info(e.getMessage());
            executorService.shutdownNow();
        }
    }
}
