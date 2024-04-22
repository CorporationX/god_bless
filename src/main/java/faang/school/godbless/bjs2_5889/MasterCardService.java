package faang.school.godbless.bjs2_5889;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

@Slf4j
public class MasterCardService {

    private static final int NUM_THREADS = Runtime.getRuntime().availableProcessors();

    public void doAll() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);
        Future<Integer> paymentFuture = executorService.submit(this::collectPayment);
        CompletableFuture<Integer> analyticsFuture = CompletableFuture.supplyAsync(this::sendAnalytics, executorService);
        analyticsFuture.thenAccept(result -> System.out.println("Analytics report: " + result));

        while (!paymentFuture.isDone()) {
            try {
                System.out.println("Payment report: " + paymentFuture.get());
            } catch (InterruptedException | ExecutionException e) {
                log.error(e.getMessage());
            }
        }
        executorService.shutdown();
        while(!executorService.awaitTermination(1, TimeUnit.MINUTES)){}
    }

    public int collectPayment() {
        try {
            Thread.sleep(10_000);
            return 10_000;
        } catch (InterruptedException e) {
            log.error(e.getMessage());
            throw new RuntimeException();
        }
    }

    public int sendAnalytics() {
        try {
            Thread.sleep(1_000);
            return 1_000;
        } catch (InterruptedException e) {
            log.error(e.getMessage());
            throw new RuntimeException();
        }
    }
}
