package school.faang.bjs2_94410;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

@Slf4j
public class MasterCardService {
    private static final int ONE_SECOND_IN_MS = 1000;
    private static final int TEN_SECONDS_IN_MS = 10000;
    private static final int FIFTEEN_SECONDS_IN_MS = 15000;
    private static final int NUM_THREAD = 2;
    private ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREAD);

    public void doAll() {
        Future<Integer> collectedPayment = executorService.submit(this::collectPayment);
        CompletableFuture.supplyAsync(this::sendAnalytics, executorService)
                .thenAccept(result -> log.info("Аналитика отправлена. Результат аналитики: {}", result))
                .thenRun(() -> {
                    try {
                        log.info("Оплата совершена. Результат оплаты: {}", collectedPayment.get());
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        throw new RuntimeException(e);
                    } catch (ExecutionException e) {
                        throw new RuntimeException(e);
                    }
                });
        executorService.shutdown();
        try {
            if (executorService.awaitTermination(FIFTEEN_SECONDS_IN_MS, TimeUnit.MILLISECONDS)) {
                log.info("Все задачи выполнены");
            } else {
                log.info("Задачи не успели выполниться");
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.info("Поток упал");
            executorService.shutdownNow();
        }
    }

    public int collectPayment() {
        try {
            Thread.sleep(TEN_SECONDS_IN_MS);
            return 5000;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }

    public int sendAnalytics() {
        try {
            Thread.sleep(ONE_SECOND_IN_MS);
            return 17000;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }
}
