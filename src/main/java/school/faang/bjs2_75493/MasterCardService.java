package school.faang.bjs2_75493;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Slf4j
public class MasterCardService {
    private static final int TEN_SECONDS_IN_MS = 10_000;
    private static final int ONE_SECOND_IN_MS = 1_000;
    private static final Integer PAYMENT = 5_000;
    private static final Integer ANALYTIC = 86_000;
    private static final Integer COUNT_POOL = 2;

    private Integer collectPayment() {
        try {
            Thread.sleep(TEN_SECONDS_IN_MS);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
        return PAYMENT;
    }

    private Integer sendAnalytics() {
        try {
            Thread.sleep(ONE_SECOND_IN_MS);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
        return ANALYTIC;
    }

    public void doAll() throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(COUNT_POOL);
        Future<Integer> paymentFuture = executor.submit(this::collectPayment);
        CompletableFuture.supplyAsync(this::sendAnalytics, executor)
                .thenAccept((analytic) -> log.info("Результат аналитики: {}", analytic)).join();
        Integer paymentFutureResult = paymentFuture.get();
        log.info("Получен результат по оплате {}", paymentFutureResult);
        executor.shutdown();
    }
}
