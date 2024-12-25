package school.faang.async_future;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Slf4j
public class Main {
    public static void main(String[] args) {
        MasterCardService paymentService = new MasterCardService();

        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<Integer> paymentResult = executor.submit(paymentService::collectPayment);

        CompletableFuture<Integer> analyticsResult = CompletableFuture.supplyAsync(paymentService::sendAnalytics);

        try {
            log.info("Payment passed: {}", paymentResult.get());
        } catch (InterruptedException e) {
            log.error("Payment process was interrupted");
        } catch (ExecutionException e) {
            log.info("Payment cancelled");
        }

        log.info("Payment info: {}", analyticsResult.join());
        executor.shutdown();
    }
}

