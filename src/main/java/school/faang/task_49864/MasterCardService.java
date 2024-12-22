package school.faang.task_49864;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;

@Slf4j
public class MasterCardService {
    public void doAll(ExecutorService executorService) {
        CompletableFuture<Integer> collectPayment = CompletableFuture
                .supplyAsync(this::collectPayment, executorService);

        CompletableFuture<Integer> sendAnalytics = CompletableFuture
                .supplyAsync(this::sendAnalytics, executorService);

        sendAnalytics.thenAccept(analytics -> {
            log.info("The analysis has been sent: {}", analytics);
            collectPayment.thenAccept(payment -> log.info("Payment completed: {}", payment));
        });
    }

    private int collectPayment() {
        try {
            Thread.sleep(10_000);
            return 10_000;
        } catch (InterruptedException e) {
            log.error(e.getMessage());
            throw new RuntimeException();
        }
    }

    private int sendAnalytics() {
        try {
            Thread.sleep(1_000);
            return 1_000;
        } catch (InterruptedException e) {
            log.error(e.getMessage());
            throw new RuntimeException();
        }
    }
}
