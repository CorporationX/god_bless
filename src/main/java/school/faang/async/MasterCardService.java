package school.faang.async;

import lombok.extern.slf4j.Slf4j;
import school.WaitUtils;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

@Slf4j
public class MasterCardService {

    private static final int PAYMENT_TIMEOUT_MILLIS = 10_000;
    private static final int ANALYTICS_TIMEOUT_MILLIS = 1_000;
    private static final int EXECUTOR_TIMEOUT_MINUTES = 1;

    public void doAll() throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        Future<Integer> payment = executor.submit(this::collectPayment);
        Future<Integer> analytics = CompletableFuture.supplyAsync(this::sendAnalytics, executor);
        log.info("Аналитика отправлена: {}", analytics.get());
        log.info("Платеж выполнен: {}", payment.get());
        WaitUtils.shutdownExecutorWithWait(executor, EXECUTOR_TIMEOUT_MINUTES, TimeUnit.MINUTES);
    }

    private int collectPayment() {
        WaitUtils.sleep(PAYMENT_TIMEOUT_MILLIS);
        return 5_000;
    }

    private int sendAnalytics() {
        WaitUtils.sleep(ANALYTICS_TIMEOUT_MILLIS);
        return 17_000;
    }
}
