package school.faang.asyncandfuture;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

@Slf4j
public class MasterCardService {
    private static final int TIME_COLLECT_PAYMENT = 10000;
    private static final int TIME_SEND_PAYMENT = 1000;
    private static final int RETURNING_VALUE_PAYMENT = 5000;
    private static final int RETURNING_VALUE_ANALYTICS = 17000;
    private static final ExecutorService EXECUTOR = Executors.newSingleThreadExecutor();
    private static final int TIME_EXECUTION = 20;
    private static final TimeUnit TIME_UNIT = TimeUnit.SECONDS;

    private int collectPayment() throws InterruptedException {
        Thread.sleep(TIME_COLLECT_PAYMENT);
        return RETURNING_VALUE_PAYMENT;
    }

    private int sendAnalytics() throws InterruptedException {
        Thread.sleep(TIME_SEND_PAYMENT);
        return RETURNING_VALUE_ANALYTICS;
    }

    public void doAll() throws ExecutionException, InterruptedException {
        Future<Integer> futurePayment = EXECUTOR.submit(this::collectPayment);
        CompletableFuture<Integer> futureAnalytics = CompletableFuture.supplyAsync(() -> {
            try {
                return sendAnalytics();
            } catch (InterruptedException exception) {
                throw new RuntimeException("Payment task interrupted", exception);
            }
        });
        log.info("Send analytics {}", futureAnalytics.join());
        log.info("Collect payment {}", futurePayment.get());
        EXECUTOR.shutdown();
        if (EXECUTOR.awaitTermination(TIME_EXECUTION, TIME_UNIT)) {
            log.info("All tasks completed");
        } else {
            log.info("Execution timed out {} {}", TIME_EXECUTION, TIME_UNIT);
            EXECUTOR.shutdownNow();
        }
    }
}
