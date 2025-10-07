package school.faang.bjs2_92775;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Slf4j
public class MasterCardService {
    private static final int PAYMENT_DEFAULT_RESULT = 5000;
    private static final int ANALYTICS_SENDING_DEFAULT_RESULT = 1000;
    private static final int PAYMENT_TIME = 10_000;
    private static final int ANALYTICS_SENDING_TIME = 1_000;
    public static final ExecutorService OPERATION_EXECUTOR = Executors.newCachedThreadPool();

    private MasterCardService() {

    }

    private static int collectPayment() {
        System.out.println("Проведение транзакции...");
        operationImitating(PAYMENT_TIME); // чтобы не дублировать код с try-catch
        System.out.println("Отлично, транзакция выполнена успешно!");
        return PAYMENT_DEFAULT_RESULT;
    }

    private static int sendAnalytics() {
        System.out.println("Отправка аналитики во время транзакции...");
        operationImitating(ANALYTICS_SENDING_TIME); // чтобы не дублировать код с try-catch
        System.out.println("Аналитика успешно отправлена!");
        return ANALYTICS_SENDING_DEFAULT_RESULT;
    }

    public static void executeOperation() throws InterruptedException, ExecutionException {
        Future<Integer> paymentResult = OPERATION_EXECUTOR.submit(MasterCardService::collectPayment);

        CompletableFuture.supplyAsync(MasterCardService::sendAnalytics, OPERATION_EXECUTOR)
                .thenAccept((result) -> log.info("Данные аналитики: {}", result))
                .join();

        int result = paymentResult.get();
        log.info("Платеж выполнен на сумму: {}", result);
    }

    private static void operationImitating(int timeInMs) {
        try {
            Thread.sleep(timeInMs);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }
}
