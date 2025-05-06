package play_in_bank;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static final int TIMEOUT = 5;

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ConcurrentHashMap<Integer, Account> accounts = new ConcurrentHashMap<>();
        accounts.put(1, new Account(1, 1000.0));
        accounts.put(2, new Account(2, 500.0));
        accounts.put(3, new Account(3, 0.0));

        Bank bank = new Bank(accounts);
        ExecutorService executorService = Executors.newFixedThreadPool(4);

        Future<Boolean> firstTransaction = executorService.submit(() -> bank.transfer(1, 2, 300));
        Future<Boolean> secondTransaction = executorService.submit(() -> bank.transfer(2, 3, 800));
        Future<Boolean> thirdTransaction = executorService.submit(() -> bank.transfer(2, 3, 200));

        try {
            System.out.println("Успех: " + firstTransaction.get());
            System.out.println("Успех: " + secondTransaction.get());
            System.out.println("Успех: " + thirdTransaction.get());
        } catch (ExecutionException | InterruptedException e) {
            log.error("Execution is failed");
            Thread.currentThread().interrupt();
        }

        double total = bank.getTotalBalance();
        System.out.println("Общий баланс в банке: " + total);

        softShutDown(executorService);
    }

    private static void softShutDown(ExecutorService executor) {
        executor.shutdown();
        try {
            if (!executor.awaitTermination(TIMEOUT, TimeUnit.SECONDS)) {
                log.warn("Forced shutdown!");
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("Thread is interrupted");
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }
}
