package school.faang.bjs2_82422;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Slf4j
public class MasterCardService {
    private static final int TEN_SECONDS_IN_MS = 10_000;
    private static final int ONE_SECOND_IN_MS = 1_000;

    static int collectPayment() {
        try {
            log.info("начинается расчет оплаты");
            Thread.sleep(TEN_SECONDS_IN_MS);
            return 5_000;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }

    static int sendAnalytics() {
        try {
            log.info("начинается отправка аналитики");
            Thread.sleep(ONE_SECOND_IN_MS);
            return 17_000;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }

    public static void doAll() {
        ExecutorService executor = Executors.newSingleThreadExecutor();

        try {
            Future<Integer> paymentResult = executor.submit(MasterCardService::collectPayment);
            CompletableFuture<Integer> analyticsResult = CompletableFuture
                    .supplyAsync(MasterCardService::sendAnalytics);
            int payment = paymentResult.get();
            log.info("результат расчета оплаты: {}", payment);

            int analytics = analyticsResult.join();
            log.info("результат отправки аналитики: {}", analytics);
        } catch (Exception e) {
            Thread.currentThread().interrupt();
            log.error("поток был прерван во время выполнения задач", e);
            throw new RuntimeException();
        } finally {
            executor.shutdown();
        }
    }
}
