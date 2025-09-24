package school.faang.future_completable_future.bjs2_92565;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static school.utils.Utils.runWithThreadErrorHandling;
import static school.utils.Utils.shutdownAndAwaitTermination;

@Slf4j
public class MasterCardService {

    private static final int TEN_SECONDS_IN_MS = 10_000;
    private static final int ONE_SECOND_IN_MS = 1_000;
    private static final int DEFAULT_PAYMENT_AMOUNT = 5_000;
    private static final int ANALYTICS_RESULT = 17_000;

    private static final ExecutorService executor = Executors.newFixedThreadPool(2);

    static int collectPayment() {
        runWithThreadErrorHandling(() -> Thread.sleep(TEN_SECONDS_IN_MS));
        return DEFAULT_PAYMENT_AMOUNT;
    }

    static int sendAnalytics() {
        runWithThreadErrorHandling(() -> Thread.sleep(ONE_SECOND_IN_MS));
        return ANALYTICS_RESULT;
    }

    public void doAll() {

        Future<Integer> collectPaymentResult = executor.submit(MasterCardService::collectPayment);

        CompletableFuture<Integer> sendAnalyticsResult = CompletableFuture
                .supplyAsync(MasterCardService::sendAnalytics, executor);

        shutdownAndAwaitTermination(executor);

        runWithThreadErrorHandling(() -> sendAnalyticsResult.get())
                .ifPresent((analytics) -> log.info("Аналитика отправлена: {}", analytics));

        runWithThreadErrorHandling(() -> collectPaymentResult.get())
                .ifPresent((paymentResult) -> log.info("Платеж выполнен: {}", paymentResult));
    }
}