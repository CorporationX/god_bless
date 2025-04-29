package school.faang.mastercard;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

@Slf4j
public class MasterCardService {
    public static final int ONE_SECOND = 1;
    public static final int TEN_SECOND = 10;

    public String collectPayment() {
        simulationProcessInSeconds(TEN_SECOND);
        return "Оплата прошла";
    }

    public String sendAnalytics() {
        simulationProcessInSeconds(ONE_SECOND);
        return "Аналитика отправлена на почту";
    }

    public void simulationProcessInSeconds(int second) {
        try {
            TimeUnit.SECONDS.sleep(second);
            log.info("Симуляция процесса в {} секунд", second);
        } catch (InterruptedException e) {
            log.info("Поток {} прерван", Thread.currentThread(), e);
            Thread.currentThread().interrupt();
        }
    }

    public void doAll() {
        ExecutorService executor = Executors.newSingleThreadExecutor();

        try {
            Future<String> resultCollectPayment = executor.submit(this::collectPayment);
            CompletableFuture<String> resultSendAnalytics = CompletableFuture.supplyAsync(
                    this::sendAnalytics, executor);
            resultSendAnalytics.thenAccept(result -> log.info("Результат отправки аналитики: {}", result));
            resultSendAnalytics.join();

            log.info("Результаты транзакции: {}", resultCollectPayment.get());
        } catch (InterruptedException e) {
            log.info("Поток {} прерван", Thread.currentThread(), e);
            Thread.currentThread().interrupt();
        } catch (ExecutionException er) {
            log.info("Поток {} прерван", Thread.currentThread(), er);
        }

        executor.shutdown();
        try {
            if (executor.awaitTermination(2, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("Поток прерван", e);
            executor.shutdownNow();
        }
    }
}