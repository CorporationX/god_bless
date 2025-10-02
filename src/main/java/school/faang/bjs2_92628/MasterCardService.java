package school.faang.bjs2_92628;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

@Slf4j
public class MasterCardService {
    private static final int TEN_SECONDS_IN_MS = 10_000;
    private static final int ONE_SECOND_IN_MS = 1_000;

    static int collectPayment() {
        try {
            log.info("Процесс оплаты начался...");
            Thread.sleep(TEN_SECONDS_IN_MS);
            log.info("Процесс оплаты завершен!");
            return 5_000;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("Процесс оплаты был прерван!");
            throw new RuntimeException(e);
        }
    }

    static int sendAnalytics() {
        try {
            log.info("Отсылка аналитики началась...");
            Thread.sleep(ONE_SECOND_IN_MS);
            log.info("Аналитика успешно отправлена!");
            return 17_000;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("Отсылка аналитики была прервана!");
            throw new RuntimeException(e);
        }
    }

    public void doAll(ExecutorService executor) {
        try {
            Future<Integer> paymentFuture = executor.submit(MasterCardService::collectPayment);
            CompletableFuture<Integer> analyticsFuture = CompletableFuture.supplyAsync(MasterCardService::sendAnalytics,
                    executor);

            log.info("Аналитика отправлена: {}", analyticsFuture.join());
            log.info("Платеж выполнен {}", paymentFuture.get());

        } catch (InterruptedException | ExecutionException e) {
            log.error("Поток был прерван или получил ошибку");
        } finally {
            executor.shutdown();
        }
    }
}
