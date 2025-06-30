package school.faang.task_82443;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

@Slf4j
public class MasterCardService {
    private static final int TEN_SECONDS_IN_MS = 10_000;
    private static final int ONE_SECOND_IN_MS = 1_000;

    public void doAll() throws ExecutionException, InterruptedException {
        ExecutorService analytics = Executors.newFixedThreadPool(2);

        Future<Integer> resultSendAnalyticsFuture = analytics.submit(MasterCardService::collectPayment);

        CompletableFuture<Integer> analyticsFuture = CompletableFuture.supplyAsync(() -> {
            log("Запускаю выполнение отправки аналитики: ");
            return sendAnalytics();
        }, analytics);


        Integer analyticsResult = analyticsFuture.join();
        log.info("Аналитика отправлена: " + analyticsResult);

        Integer paymentResult = resultSendAnalyticsFuture.get();
        log.info("Платеж выполнен: " + paymentResult);
    }

    static int collectPayment() {
        try {
            Thread.sleep(TEN_SECONDS_IN_MS);
            log("Обработка платежа завершена");
            return 5_000;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }

    public int sendAnalytics() {
        try {
            Thread.sleep(ONE_SECOND_IN_MS);
            log("Отправка аналитики завершена");
            return 17_000;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }

    private static void log(String message) {
        log.info("[" + Thread.currentThread().getName() + "] " + message);
    }


}
