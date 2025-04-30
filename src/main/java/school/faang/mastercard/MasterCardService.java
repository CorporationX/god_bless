package school.faang.mastercard;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

@Slf4j
public class MasterCardService {
    public static final int ONE_SECOND = 1;
    public static final int TEN_SECOND = 10;
    public static final int TERMINATION_TIMEOUT_SECONDS = 2;

    public int collectPayment() {
        simulationProcessInSeconds(TEN_SECOND);
        return 7_000;
    }

    public int sendAnalytics() {
        simulationProcessInSeconds(ONE_SECOND);
        return 15_000;
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

    public void doAll(ExecutorService executor) {
        try {
            Future<Integer> resultCollectPayment = executor.submit(this::collectPayment);
            CompletableFuture<Integer> resultSendAnalytics = CompletableFuture.supplyAsync(
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
    }

    public void gracefullyShutdown(ExecutorService executor) {
        executor.shutdown();
        try {
            if (executor.awaitTermination(TERMINATION_TIMEOUT_SECONDS, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("Поток прерван", e);
            executor.shutdownNow();
        }
    }
}