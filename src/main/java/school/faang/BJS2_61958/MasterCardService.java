package school.faang.BJS2_61958;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class MasterCardService {
    private static final int TEN_SECONDS_IN_MS = 10_000;
    private static final int ONE_SECOND_IN_MS = 1_000;
    private static final int THREADS_COUNT = 2;

    private static int collectPayment() {
        try {
            Thread.sleep(TEN_SECONDS_IN_MS);
            return 5_000;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }

    private static int sendAnalytics() {
        try {
            Thread.sleep(ONE_SECOND_IN_MS);
            return 17_000;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }

    public void doAll() {
        ExecutorService executor = Executors.newFixedThreadPool(THREADS_COUNT);
        CompletableFuture.supplyAsync(MasterCardService::collectPayment, executor)
                .thenAccept(s -> log.info("Payment completed: {}", s));
        CompletableFuture.supplyAsync(MasterCardService::sendAnalytics, executor)
                .thenAccept(s -> log.info("The analysis has been sent: {}", s));
        executor.shutdown();
    }

}
