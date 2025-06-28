package school.faang.bjs2_82422;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

@Slf4j
public class MasterCardService {
    private static final int TEN_SECONDS_IN_MS = 10_000;
    private static final int ONE_SECOND_IN_MS = 1_000;

    public int collectPayment() {
        try {
            log.info("начинается расчет оплаты");
            Thread.sleep(TEN_SECONDS_IN_MS);
            return 5_000;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }

    public int sendAnalytics() {
        try {
            log.info("начинается отправка аналитики");
            Thread.sleep(ONE_SECOND_IN_MS);
            return 17_000;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }

    public void runPaymentAndAnalytics(ExecutorService executor) {
        try {
            Future<Integer> paymentResult = executor.submit(this::collectPayment);
            int payment = paymentResult.get();
            log.info("результат расчета оплаты: {}", payment);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("поток был прерван во время оплаты", e);
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            log.error("поток был прерван во время расчета оплаты", e);
            throw new RuntimeException(e);
        }

        try {
            CompletableFuture<Integer> analyticsResult = CompletableFuture
                    .supplyAsync(this::sendAnalytics, executor);
            int analytics = analyticsResult.join();
            log.info("результат отправки аналитики: {}", analytics);
        } catch (CompletionException e) {
            log.error("ошибка во время аналитики", e);
            throw new RuntimeException(e);
        }

        executor.shutdown();
        try {
            if (!executor.awaitTermination(10, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}
