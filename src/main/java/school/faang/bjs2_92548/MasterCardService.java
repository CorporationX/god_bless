package school.faang.bjs2_92548;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

@Slf4j
public class MasterCardService {
    private static final int TEN_SECONDS_IN_MS = 10_000;
    private static final int ONE_SECOND_IN_MS = 1_000;
    private static final int PAYMENT_AMOUNT = 5_000;
    private static final int ANALYTICS_AMOUNT = 17_000;
    private static final int MAX_WAIT_TIME = 1;

    static int collectPayment() {
        try {
            Thread.sleep(TEN_SECONDS_IN_MS);
            return PAYMENT_AMOUNT;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }

    static int sendAnalytics() {
        try {
            Thread.sleep(ONE_SECOND_IN_MS);
            return ANALYTICS_AMOUNT;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }

    public void doAll() {
        ExecutorService executor = Executors.newSingleThreadExecutor();

        try {
            Future<Integer> paymentFuture = executor.submit(MasterCardService::collectPayment);

            CompletableFuture<Integer> analyticsFuture =
                    CompletableFuture.supplyAsync(MasterCardService::sendAnalytics, executor);

            int analyticsResult = analyticsFuture.join();
            System.out.println("Аналитика отправленна: " + analyticsResult);

            int paymentResult = paymentFuture.get();
            System.out.println("Платёж выполнен: " + paymentResult);

        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            executor.shutdown();
        }
    }

    private static void gracefullyShutdown(ExecutorService executor) {
        executor.shutdown();
        try {
            if (!executor.awaitTermination(MAX_WAIT_TIME, TimeUnit.MINUTES)) {
                log.warn("Не все задачи завершились вовремя, принудительно закрываем пул потоков...");
                executor.shutdownNow();
            } else {
                log.info("Все задачи выполнены успешно.");
            }
        } catch (InterruptedException e) {
            log.error("Главный поток был прерван.");
            executor.shutdownNow();
        }
    }

    public static void main(String[] args) {
        MasterCardService service = new MasterCardService();
        service.doAll();
    }
}
