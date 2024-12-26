package school.faang.sprint_4.task_bjs249894;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Slf4j
public class Main {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<Integer> collectPayment = executorService.submit(MasterCardService::collectPayment);
        CompletableFuture<Integer> sendAnalytics = CompletableFuture.supplyAsync(MasterCardService::sendAnalytics);

        try {
            log.info("Analytics sent: {}", sendAnalytics.get());
            log.info("Collected payment: {}", collectPayment.get());
        } catch (InterruptedException | ExecutionException e) {
            log.warn("Thread {} was interrupted", Thread.currentThread().getName());
            Thread.currentThread().interrupt();
        } finally {
            executorService.shutdown();
        }
    }
}
