package faang.school.godbless.async_and_future;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Slf4j
public class Main {
    private static final int THREAD_POOL_SIZE = 2;

    public static void main(String[] args) {
        try {
            doAll();
        } catch (ExecutionException | InterruptedException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public static void doAll() throws ExecutionException, InterruptedException {
        MasterCardService masterCardService = new MasterCardService();
        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_POOL_SIZE);

        Future<Integer> futureResult = executorService.submit(masterCardService::collectPayment);
        CompletableFuture.supplyAsync(masterCardService::sendAnalytics, executorService)
                .thenAccept(result -> log.info("Received from sendAnalytics method: {}", result));
        log.info("Received from collectPayment method: {}", futureResult.get());

        executorService.shutdown();
    }
}