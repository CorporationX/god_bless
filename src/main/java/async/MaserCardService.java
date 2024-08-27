package async;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@Slf4j
public class MaserCardService {
    private static final int POOL_SIZE = 2;

    private int collectPayment() {
        return ThreadLocalRandom.current().nextInt(1000);
    }

    private int sendAnalytics() {
        return ThreadLocalRandom.current().nextInt(100);
    }

    public void doAll() {
        try (ExecutorService executor = Executors.newFixedThreadPool(POOL_SIZE)) {
            Future<Integer> resultOfCollection = executor.submit(this::collectPayment);
            CompletableFuture<Integer> resultOfSending = CompletableFuture.supplyAsync(this::sendAnalytics, executor);
            try {
                log.info("Sending result: " +
                        resultOfSending.get(30, TimeUnit.SECONDS));
                log.info("Collection result: " +
                        resultOfCollection.get(30, TimeUnit.SECONDS));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            } catch (ExecutionException | TimeoutException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
