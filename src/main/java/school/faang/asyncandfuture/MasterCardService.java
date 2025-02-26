package school.faang.asyncandfuture;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Slf4j
public class MasterCardService {
    private static final int TIME_COLLECT_PAYMENT = 10000;
    private static final int TIME_SEND_PAYMENT = 1000;
    private static final ExecutorService EXECUTOR = Executors.newSingleThreadExecutor();

    private int collectPayment() throws InterruptedException {
        Thread.sleep(TIME_COLLECT_PAYMENT);
        return TIME_COLLECT_PAYMENT;
    }

    private int sendAnalytics() throws InterruptedException {
        Thread.sleep(TIME_SEND_PAYMENT);
        return TIME_SEND_PAYMENT;
    }

    public void doAll() throws ExecutionException, InterruptedException {
        Future<Integer> futureAnalytics = EXECUTOR.submit(this::sendAnalytics);
        CompletableFuture<Integer> futurePayment = CompletableFuture.supplyAsync(() -> {
            try {
                return collectPayment();
            } catch (InterruptedException exception) {
                throw new RuntimeException("Payment task interrupted", exception);
            }
        });
        log.info("Send analytics {}", futureAnalytics.get());
        log.info("Collect payment {}", futurePayment.join());
        EXECUTOR.shutdown();
    }
}
