package school.faang.task_49865;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Slf4j
public class MasterCardService {
    public static final int TEN_SECONDS = 10_000;
    public static final int ONE_SECOND = 1_000;

    @SneakyThrows
    public int collectPayment() {
        log.info("Process payment started...");
        Thread.sleep(TEN_SECONDS);
        log.info("Process payment ended!");
        return 10_000;
    }

    @SneakyThrows
    public int sendAnalytics() {
        log.info("Send analytics started...");
        Thread.sleep(ONE_SECOND);
        log.info("Send analytics ended");
        return 1_000;
    }

    public void doAll() throws ExecutionException, InterruptedException {
        var executorService = Executors.newSingleThreadExecutor();
        Future<Integer> future = executorService.submit(this::collectPayment);
        CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(this::sendAnalytics);
        int analytics = completableFuture.get();
        log.info("Analytics sent: {}", analytics);
        int payment = future.get();
        log.info("Payment is done: {}", payment);
        executorService.shutdown();
    }
}
