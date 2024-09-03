package faang.school.godbless.AsynchronyAndFuture;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

@Slf4j
public class MasterCardService {
    private static final int POOL_SIZE = 2;

    void doAll() {
        try (ExecutorService executor = Executors.newFixedThreadPool(POOL_SIZE)) {
            Future<Integer> resultOfCollection = executor.submit(this::collectPayment);
            CompletableFuture<Integer> resultOfSending = CompletableFuture.supplyAsync(this::sendAnalytics, executor);

            try {
                log.info("Sending result: {}", resultOfSending.get(30, TimeUnit.SECONDS));
                log.info("Collection result: {}", resultOfCollection.get(30, TimeUnit.SECONDS));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            } catch (ExecutionException | TimeoutException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private int collectPayment() {
        try {
            Thread.sleep(10_000);
            return 10_000;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException();
        }
    }

    private int sendAnalytics() {
        try {
            Thread.sleep(1_000);
            return 1_000;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException();
        }
    }
}
