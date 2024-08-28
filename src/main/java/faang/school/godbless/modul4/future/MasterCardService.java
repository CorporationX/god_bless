package faang.school.godbless.modul4.future;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

@Slf4j
@RequiredArgsConstructor
public class MasterCardService {
    private final ExecutorService executorService;

    public void doAll() {
        var analyticsFuture = CompletableFuture.supplyAsync(this::sendAnalystics, executorService);
        analyticsFuture.thenAccept(result -> log.info("Received analytics = " + result));

        var paymentFuture = executorService.submit(this::collectPayment);
        while (!paymentFuture.isDone()) {
            try {
                log.info("Collected payment = " + paymentFuture.get());
            } catch (InterruptedException | ExecutionException e) {
                log.error(e.getMessage());
                throw new RuntimeException(e);
            }
        }

        executorService.shutdown();
        try {
            if (executorService.awaitTermination(20, TimeUnit.SECONDS)) {
                log.info("All task complete!");
            } else {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public int collectPayment() {
        try {
            Thread.sleep(5_000);
            return 10_000;
        } catch (InterruptedException e) {
            log.error(e.getMessage());
            throw new RuntimeException();
        }
    }

    public int sendAnalystics() {
        try {
            Thread.sleep(1_000);
            return 1_000;
        } catch (InterruptedException e) {
            log.error(e.getMessage());
            throw new RuntimeException();
        }
    }
}
