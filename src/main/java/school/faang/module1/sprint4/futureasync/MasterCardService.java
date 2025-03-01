package school.faang.module1.sprint4.futureasync;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

@Slf4j
public class MasterCardService {
    private static final int TEN_SECONDS_IN_MS = 10_000;
    private static final int ONE_SECOND_IN_MS = 1_000;
    private static final int AWAIT_MIN = 1;

    static int collectPayment() {
        try {
            Thread.sleep(TEN_SECONDS_IN_MS);
            return 5_000;
        } catch (InterruptedException e) {
            log.debug("Поток был прерван во время процесса оплаты");
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }

    static int sendAnalytics() {
        try {
            Thread.sleep(ONE_SECOND_IN_MS);
            return 17_000;
        } catch (InterruptedException e) {
            log.debug("Поток был прерван во время отправки аналитики");
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }

    public void doAll() {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<Integer> resultPayment = executorService.submit(MasterCardService::collectPayment);

        CompletableFuture<Integer> resultAnalytics = CompletableFuture.supplyAsync(MasterCardService::sendAnalytics);

        try {
            log.info("\nАналитика отправлена: {}\nПлатеж выполнен: {}", resultAnalytics.get(), resultPayment.get());
        } catch (InterruptedException e) {
            log.debug("Поток был прерван");
            Thread.currentThread().interrupt();
            throw new RuntimeException("Поток был прерван", e);
        } catch (ExecutionException e) {
            log.debug("Ошибка при выполнении");
            throw new RuntimeException("Ошибка при выполнении", e);
        }

        executorService.shutdown();

        try {
            if (!executorService.awaitTermination(AWAIT_MIN, TimeUnit.MINUTES)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.debug("Во время ожидания завершения работы потока, поток был прерван");
            Thread.currentThread().interrupt();
            throw new RuntimeException("Во время ожидания завершения работы потока, поток был прерван", e);
        }
    }
}