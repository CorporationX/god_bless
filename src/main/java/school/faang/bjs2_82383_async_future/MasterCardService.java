package school.faang.bjs2_82383_async_future;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import school.faang.utils.ThreadUtils;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

@Slf4j
@AllArgsConstructor
public class MasterCardService {

    private static final int TEN_SECONDS_IN_MS = 10_000;
    private static final int ONE_SECOND_IN_MS = 1_000;
    private final ExecutorService executorService;

    private int collectPayment() {
        try {
            Thread.sleep(TEN_SECONDS_IN_MS);
            return 5_000;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }

    private int sendAnalytics() {
        try {
            Thread.sleep(ONE_SECOND_IN_MS);
            return 17_000;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }

    public void executePaymentAndAnalyticsAsync() {
        Future<Integer> paymentFuture = executorService.submit(this::collectPayment);
        CompletableFuture<Void> analyticsFuture = CompletableFuture
                .supplyAsync(this::sendAnalytics, executorService)
                .thenAccept(sum -> log.info("Analytics result: {}", sum.toString()));

        analyticsFuture.join();
        try {
            Integer paymentResult = paymentFuture.get();
            log.info("Payment result: {}", paymentResult.toString());
        } catch (InterruptedException | ExecutionException e) {
            log.error("Payment processing could not complete: {}", e.getMessage());
            throw new RuntimeException(e);
        }

        ThreadUtils.executorGracefulShutdown(executorService, 1);

    }

}
