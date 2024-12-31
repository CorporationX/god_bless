package school.faang.bjs249906;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

@Slf4j
public class Main {
    public static void main(String[] args) {

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<Integer> paymentFutur = executorService.submit(MasterCardService::collectPayment);

        CompletableFuture<Integer> analyticsCompFutur = CompletableFuture.supplyAsync(MasterCardService::sendAnalytics);

        try {
            log.info("Analytics sent: {}", analyticsCompFutur.join());
            log.info("Payment completed: {}", paymentFutur.get());
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }

        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(5, TimeUnit.SECONDS)) {
                log.info("The tasks were not completed in 5 seconds, stoped the ThreadPool forcefully");
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("The main thread {} was interrupted while waiting",
                    Thread.currentThread().getName());
        }
    }
}