package faang.school.godbless.mt.asyncfuture;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Slf4j
public class MasterCardService {
    private static final int THREAD_COUNT = 10;
    private final ExecutorService executor;

    public MasterCardService() {
        this.executor = Executors.newFixedThreadPool(THREAD_COUNT);
    }

    public int collectPayment() {
        try {
            Thread.sleep(10_000);
            return 10_000;
        } catch (InterruptedException e) {
            throw new IllegalStateException("Thread interrupted", e);
        }
    }

    static int sendAnalytics() {
        try {
            Thread.sleep(1_000);
            return 1_000;
        } catch (InterruptedException e) {
            throw new IllegalStateException("Thread interrupted", e);
        }
    }

    public void doAll() {
        try {
            Future<Integer> paymentFuture = executor.submit(this::collectPayment);
            CompletableFuture<Integer> analyticsFuture = CompletableFuture.supplyAsync(MasterCardService::sendAnalytics, executor);

            Integer analyticsResult = analyticsFuture.join();
            log.info("Analytics sent: {}", analyticsResult);

            Integer paymentResult = paymentFuture.get();
            log.info("Payment collected: {}", paymentResult);

        } catch (Exception e) {
            log.error("Execution service exception", e);
        }
    }

}
