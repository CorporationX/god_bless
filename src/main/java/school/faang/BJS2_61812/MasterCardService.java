package school.faang.BJS2_61812;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.*;

@Slf4j
public class MasterCardService {
    private static final int TEN_SECONDS_IN_MS = 10_000;
    private static final int ONE_SECOND_IN_MS = 1_000;
    private static final int RETURN_VALUE1 = 5_000;
    private static final int RETURN_VALUE2 = 17_000;

    private static int collectPayment() {
        try {
            log.info("Начало сбора платежа. Ожидание {} мс...", TEN_SECONDS_IN_MS);
            Thread.sleep(TEN_SECONDS_IN_MS);
            log.info("Сбор платежа успешно завершен. Возвращаемое значение: {}", RETURN_VALUE1);
            return RETURN_VALUE1;
        } catch (InterruptedException e) {
            log.error("Прерван процесс сбора платежа. Причина: {}. Текущий поток: {}",
                    e.getMessage(), Thread.currentThread().getName(), e);
            Thread.currentThread().interrupt();
            log.error("Дополнительные параметры: TEN_SECONDS_IN_MS = {}", TEN_SECONDS_IN_MS);
            throw new RuntimeException("Ошибка при сборе платежа: " + e.getMessage(), e);
        }
    }

    private static int sendAnalytics() {
        try {
            Thread.sleep(ONE_SECOND_IN_MS);
            return RETURN_VALUE2;
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