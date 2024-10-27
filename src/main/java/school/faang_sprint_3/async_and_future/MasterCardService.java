package school.faang_sprint_3.async_and_future;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class MasterCardService {
    private final ExecutorService threadPool = Executors.newFixedThreadPool(2);

    public void doAll() {
        CompletableFuture.supplyAsync(this::sendAnalytics, threadPool)
                .thenAccept(analytics -> log.info("Analytics send: {} ", analytics));
        CompletableFuture.supplyAsync(this::collectPayment, threadPool)
                .thenAccept(payments -> log.info("Payment send: ${} ", payments))
                .join();
        threadPool.shutdown();
    }

    private int sendAnalytics() {
        try {
            Thread.sleep(1000);
            return 1000;
        } catch (InterruptedException e) {
            log.error("An exception occurred while sending analytics", e);
            throw new IllegalStateException(e);
        }
    }

    private int collectPayment() {
        try {
            Thread.sleep(5000);
            return 10000;
        } catch (InterruptedException e) {
            log.error("An exception occurred while collecting payment", e);
            throw new IllegalStateException(e);
        }
    }

}
