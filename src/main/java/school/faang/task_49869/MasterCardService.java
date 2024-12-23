package school.faang.task_49869;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;

@Slf4j
public class MasterCardService {

    private static final int THREAD_DELAY = 1000;

    public void doAll(ExecutorService executorService) {
        CompletableFuture<Integer> collectPayment =
                CompletableFuture.supplyAsync(this::collectPayment, executorService);
        CompletableFuture<Integer> sendAnalytics =
                CompletableFuture.supplyAsync(this::sendAnalytics, executorService);

        sendAnalytics.thenAccept(analytics -> {
            log.info("Аналитика отправлена: {}", analytics);
            collectPayment.thenAccept(payment -> log.info("Платеж выполнен: {}", payment));
        }).join();
    }

    private int collectPayment() {
        try {
            Thread.sleep(10_000);
            return 10_000;
        } catch (InterruptedException e) {
            log.error("Ошибка в collectPayment: {}", e.getMessage());
            Thread.currentThread().interrupt();
            return 0;
        }
    }

    private int sendAnalytics() {
        try {
            Thread.sleep(THREAD_DELAY);
            return 1000;
        } catch (InterruptedException e) {
            log.error("Ошибка в sendAnalytics: {}", e.getMessage());
            return 0;
        }
    }
}