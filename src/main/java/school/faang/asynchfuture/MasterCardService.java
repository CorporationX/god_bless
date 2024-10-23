package school.faang.asynchfuture;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Slf4j
public class MasterCardService {
    private final ExecutorService executor = Executors.newSingleThreadExecutor();

    public static int collectPayment() {
        try {
            Thread.sleep(10_000);
            return 10_000;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    static int sendAnalytics() {
        try {
            Thread.sleep(1_000);
            return 1_000;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    public void doAll() {
        Future<Integer> paymentFuture = executor.submit(MasterCardService::collectPayment);

        CompletableFuture<Integer> analyticsFuture =  CompletableFuture.supplyAsync(MasterCardService::sendAnalytics, Executors.newCachedThreadPool());

        log.info("Sent analytics: {}", analyticsFuture.join());

        try {
            log.info("Sent analytics: {}", paymentFuture.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        log.info("It's ok");

        executor.shutdownNow();
    }
}
