package school.faang.async_and_future;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

@Slf4j
public class MasterCardService {
    private static final int DURATION_OF_COLLECTING_PAYMENTS = 10_000;
    private static final int DURATION_OF_SENDING_ANALYTICS = 1_000;
    private static final int PAYMENT_RESULT = 5_000;
    private static final int ANALYTIC_RESULT = 17_000;
    private static final ExecutorService service = Executors.newFixedThreadPool(2);

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        doAll();
    }

    private static void doAll() throws ExecutionException, InterruptedException {
        Future<Integer> paymentFuture = service.submit(MasterCardService::collectPayment);
        CompletableFuture.supplyAsync(MasterCardService::sendAnalytics, service)
                .thenAccept((analytics) -> log.info("Аналитика отправлена: {}", analytics))
                .join();

        Integer paymentResult = paymentFuture.get();
        log.info("Платеж выполнен: {}", paymentResult);

        service.shutdown();

        try {
            if (!service.awaitTermination(1, TimeUnit.MINUTES)) {
                service.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("Не все задачи были выполнены");
            service.shutdownNow();
        }
    }

    private static int collectPayment() {
        try {
            Thread.sleep(DURATION_OF_COLLECTING_PAYMENTS);
            return PAYMENT_RESULT;
        } catch (InterruptedException e) {
            log.error("Выполнение сбора платежей было прервано с ошибкой {}", e.getMessage());
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }

    private static int sendAnalytics() {
        try {
            Thread.sleep(DURATION_OF_SENDING_ANALYTICS);
            return ANALYTIC_RESULT;
        } catch (InterruptedException e) {
            log.error("Выполнение отправки аналитики было прервано с ошибкой {}", e.getMessage());
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }
}
