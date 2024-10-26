package mastercard;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MasterCardService {
    private static final Logger logger = LoggerFactory.getLogger(MasterCardService.class);

    public static int collectPayment() {
        try {
            Thread.sleep(10_000);
            return 10_000;
        } catch (InterruptedException error) {
            Thread.currentThread().interrupt();
            logger.error("Процесс оплаты был прерван", error);
            throw new RuntimeException(error);
        }
    }

    public static int sendAnalytics() {
        try {
            Thread.sleep(1_000);
            return 1_000;
        } catch (InterruptedException error) {
            Thread.currentThread().interrupt();
            logger.error("Процесс отправки аналитики был прерван", error);
            throw new RuntimeException(error);
        }
    }

    public void doAll() {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        try {
            Future<Integer> paymentPromise = executorService.submit(MasterCardService::collectPayment);
            CompletableFuture<Integer> analyticsPromise = CompletableFuture.supplyAsync(
                    MasterCardService::sendAnalytics, executorService
            );

            analyticsPromise.thenAccept(result ->
                    logger.info("Аналитика отправлена {}", result)
            );

            analyticsPromise.join();

            try {
                Integer paymentResult = paymentPromise.get();
                logger.info("Платеж выполнен {}", paymentResult);
            } catch (InterruptedException error) {
                logger.error("Ошибка в обработке платежа", error);
            }

        } catch (ExecutionException | RuntimeException error) {
            logger.error("Ошибка в обработке платежа", error);

        } finally {
            executorService.shutdown();
        }
    }
}
