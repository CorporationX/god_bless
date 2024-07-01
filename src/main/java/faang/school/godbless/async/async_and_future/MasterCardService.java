package faang.school.godbless.async.async_and_future;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

@Slf4j
public class MasterCardService {
    private final int POOL_SIZE = 2;
    private final ExecutorService SINGLE_EXECUTOR = Executors.newSingleThreadExecutor();
    private final ExecutorService EXECUTOR = Executors.newFixedThreadPool(POOL_SIZE);
    private final int DURATION_COLLECTED_PAYMENT = 10_000;
    private final int DURATION_SEND_ANALYSTICS = 1000;

    public void doAll() {
        Future<Integer> payment = SINGLE_EXECUTOR.submit(this::collectPayment);
        CompletableFuture<Integer> analytics = CompletableFuture.supplyAsync(this::sendAnalystics, EXECUTOR);

        log.info(String.format("Result analytics %d", analytics.join()));
        try {
            log.info(String.format("Result payment %d", payment.get()));
        } catch (InterruptedException e) {
            log.error("Thread payment  was interrupted");
            throw new RuntimeException("Thread payment  was interrupted", e);
        } catch (ExecutionException e) {
            log.error("Thread payment  was terminated with ExecutionException");
            throw new RuntimeException("Thread payment  was terminated with ExecutionException", e);
        }

        try {
            EXECUTOR.awaitTermination(2, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            log.error("Thread analytics  was interrupted when during execution await termination");
            throw new RuntimeException("Thread analytics  was interrupted when during execution await termination", e);
        }
        try {
            SINGLE_EXECUTOR.awaitTermination(2, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            log.error("Thread payment  was interrupted when during execution await termination");
            throw new RuntimeException("Thread payment  was interrupted when during execution await termination", e);
        }
        EXECUTOR.shutdown();
        SINGLE_EXECUTOR.shutdown();
    }

    public int collectPayment() {
        try {
            Thread.sleep(DURATION_COLLECTED_PAYMENT);
            return DURATION_COLLECTED_PAYMENT;
        } catch (InterruptedException e) {
            e.printStackTrace();
            log.error("Thread in collectPayment was interrupted");
            throw new RuntimeException("Thread in collectPayment was interrupted", e);
        }
    }

    public int sendAnalystics() {
        try {
            Thread.sleep(DURATION_SEND_ANALYSTICS);
            return DURATION_SEND_ANALYSTICS;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("Thread interrupted during analytics sending");
            throw new RuntimeException("Thread interrupted during analytics sending", e);
        }
    }
}
