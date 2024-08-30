package faang.school.godbless.bjs2_24821;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Slf4j
public class MasterCardService {
    public int collectPayment() {
        try {
            Thread.sleep(5_000);
            return 5_000;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    public int sendAnalytics() {
        try {
            Thread.sleep(1_000);
            return 1_000;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    public void doAll() throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        Future<Integer> collectPaymentFuture = executorService.submit(this::collectPayment);

        CompletableFuture.supplyAsync(this::sendAnalytics, executorService)
                .thenAccept(result -> log.info("Send analytics result: " + result))
                .join();

        while (!collectPaymentFuture.isDone()) {
        }
        log.info("Collect payment result: " + collectPaymentFuture.get());

        executorService.shutdown();
    }
}
