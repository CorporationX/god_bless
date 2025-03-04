package school.faang.task_61998;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Slf4j
public class MasterCardService {
    private static final int TEN_SECONDS_IN_MS = 10_000;
    private static final int ONE_SECOND_IN_MS = 1_000;
    private static final int ONE_PRICE = 5_000;
    private static final int TWO_PRICE = 17_000;

    static int collectPayment() throws PaymentProcessingException {
        try {
            Thread.sleep(TEN_SECONDS_IN_MS);
            return ONE_PRICE;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new PaymentProcessingException("Ошибка при сборе платежа", e);
        }
    }

    static int sendAnalytics() throws PaymentProcessingException {
        try {
            Thread.sleep(ONE_SECOND_IN_MS);
            return TWO_PRICE;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new PaymentProcessingException("Ошибка при отправке аналитики", e);
        }
    }

    public void doAll() throws PaymentProcessingException {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<Integer> futureCollectPayment = executor.submit(() -> {
            try {
                return collectPayment();
            } catch (PaymentProcessingException e) {
                log.error("Ошибка при обработке платежа: {}", e.getMessage());
                return 0;
            }
        });

        CompletableFuture<Integer> futureSendAnalytics = CompletableFuture
                .supplyAsync(() -> {
                    try {
                        return sendAnalytics();
                    } catch (PaymentProcessingException e) {
                        log.error("Ошибка при отправке аналитики: {}", e.getMessage());
                        return 0;
                    }
                });

        log.info("Произведена отправка аналитики: {}", futureSendAnalytics.join());
        try {
            log.info("Платеж: {}", futureCollectPayment.get());
        } catch (InterruptedException | ExecutionException e) {
            throw new PaymentProcessingException("Ошибка при получении результата платежа", e);
        }
        executor.shutdown();
    }
}
