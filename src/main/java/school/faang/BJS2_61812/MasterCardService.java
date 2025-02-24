package school.faang.BJS2_61812;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.*;

@Slf4j
public class MasterCardService {
    private static final int TEN_SECONDS_IN_MS = 10_000;
    private static final int ONE_SECOND_IN_MS = 1_000;

    private static int collectPayment() {
        try {
            Thread.sleep(TEN_SECONDS_IN_MS);
            return 5_000;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("Прерван процесс сбора платежа", e);
            throw new RuntimeException(e);
        }
    }

    private static int sendAnalytics() {
        try {
            Thread.sleep(ONE_SECOND_IN_MS);
            return 17_000;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("Прерван процесс отправки аналитики", e);
            throw new RuntimeException(e);
        }
    }

    private static final  ExecutorService pool = Executors.newSingleThreadExecutor();

    static void doAll() throws ExecutionException, InterruptedException {
        Future<Integer> paymentFuture = pool.submit(MasterCardService::collectPayment);

        CompletableFuture<Integer> analyticsFuture = CompletableFuture.supplyAsync(MasterCardService::sendAnalytics);

        Integer paymentResult = paymentFuture.get();
        log.debug("Платеж прошел : {}", paymentResult);
        Integer analyticsResult = analyticsFuture.join();
        log.debug("Аналитика отправлена :{}", analyticsResult);

        pool.shutdown();
    }
}