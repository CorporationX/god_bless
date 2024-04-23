package faang.school.godbless.module.fourth.async.stripe;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MasterCardService {
    public int collectPayment() {
        try {
            Thread.sleep(5_000);
            return 10_000;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
    
    public int sendAnalytics() {
        try {
            Thread.sleep(1_000);
            return 1_000;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
    
    public void doAll() {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<Integer> payment = executorService.submit(() -> collectPayment());
        CompletableFuture<Integer> analytics = CompletableFuture.supplyAsync(() -> sendAnalytics());
        try {
            log.info("Analytics result {}", analytics.get());
            log.info("Payment result {}", payment.get());
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
        executorService.shutdown();
    }
}
