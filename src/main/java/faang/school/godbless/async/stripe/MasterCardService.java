package faang.school.godbless.async.stripe;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Slf4j
public class MasterCardService {

    public int collectPayment() {
        try {
            Thread.sleep(3000);
            return 10_000;
        } catch (InterruptedException e) {
            log.error(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public int sendAnalytics() {
        try {
            Thread.sleep(3000);
            return 5_000;
        } catch (InterruptedException e) {
            log.error(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public void doAll() {
        var threadPool = Executors.newSingleThreadExecutor();
        Future<Integer> payment = threadPool.submit(this::collectPayment);
        var analyticsFuture = CompletableFuture.supplyAsync(this::sendAnalytics, threadPool);
        try {
            log.info("Gathering analytics: {}", analyticsFuture.join());
            log.info("Payment is collected: {}", payment.get());
        } catch (InterruptedException | ExecutionException e) {
            log.error(e.getMessage());
            throw new RuntimeException(e);
        } finally {
            threadPool.shutdown();
        }
    }
}

