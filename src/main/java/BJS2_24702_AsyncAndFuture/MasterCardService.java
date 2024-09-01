package BJS2_24702_AsyncAndFuture;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

@Slf4j
public class MasterCardService {
    static int collectPayment() {
        try {
            Thread.sleep(10_000);
            return 10_000;
        } catch (InterruptedException e) {
            log.error("Error! Thread got interrupted with: ", e);
            throw new RuntimeException();
        }
    }

    static int sendAnalytics() {
        try {
            Thread.sleep(1_000);
            return 1_000;
        } catch (InterruptedException e) {
            log.error("Error! Thread got interrupted with: ", e);
            throw new RuntimeException();
        }
    }

    public void doAll() {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<Integer> collected = executor.submit(MasterCardService::collectPayment);
        CompletableFuture.supplyAsync(MasterCardService::sendAnalytics, executor)
                .thenAcceptAsync(analyticsResult -> log.info("Analytics result is : {}", analyticsResult)).join();
        int collectedResult = 0;
        try {
            collectedResult = collected.get();
        } catch (InterruptedException | ExecutionException e) {
            log.error("The thread was interrupted!", e);
        }
        log.info("Collected payments: {}", collectedResult);
        executor.shutdown();
        try {
            if (!executor.awaitTermination(15, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.warn("Timed out!");
            executor.shutdownNow();
        }
    }
}
