package school.faang.bjs2_75493;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Slf4j
public class MasterCardService {
    private static final int TEN_SECONDS_IN_MS = 10_000;
    private static final int ONE_SECOND_IN_MS = 1_000;

    private static final String PAYMENT = "Оплата прошла";
    private static final String ANALYTIC = "Аналитика получена";

    private String collectPayment(){
        try {
            Thread.sleep(TEN_SECONDS_IN_MS);
            return PAYMENT;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }

    private String sendAnalytics(){
        try {
            Thread.sleep(ONE_SECOND_IN_MS);
            return ANALYTIC;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }

    public void doAll() throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(5);
        Future<String> future = executor.submit(this::collectPayment);
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(this::sendAnalytics);
        log.info(completableFuture.join());
        log.info(future.get());
        executor.shutdown();
    }
}
