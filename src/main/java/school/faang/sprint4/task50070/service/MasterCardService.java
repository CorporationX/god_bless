package school.faang.sprint4.task50070.service;


import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

@Slf4j
public class MasterCardService {
    private static final int TIME_TO_PAYMENT_PROC_SEC = 10;
    private static final int TIME_TO_SEND_ANALYTICS_SEC = 1;

    public int collectPayment() {
        processPayment();
        return 10_000;
    }

    public int sendAnalytics() {
        try {
            Thread.sleep(TIME_TO_SEND_ANALYTICS_SEC * 1000);
        } catch (InterruptedException e) {
            log.error(e.getMessage());
            throw new RuntimeException();
        }
        return 1_000;
    }

    private void processPayment() {
        try {
            Thread.sleep(TIME_TO_PAYMENT_PROC_SEC * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void doAll() {
        ExecutorService executor = Executors.newSingleThreadExecutor();

        log.info("Application starts the work");
        Future<Integer> payment = executor.submit(this::collectPayment);
        CompletableFuture<Integer> data = CompletableFuture.supplyAsync(this::sendAnalytics);

        log.info("Application data recieved: " + data.join());

        try {
            log.info("Application payments recieved: " + payment.get());
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }

        executor.shutdown();

        log.info("Application finishes the work");
    }
}
