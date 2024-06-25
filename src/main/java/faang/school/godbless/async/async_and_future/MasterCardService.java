package faang.school.godbless.async.async_and_future;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

@Slf4j
public class MasterCardService {
    private final int POOL_SIZE = 2;
    private final ExecutorService SINGLE_EXECUTOR = Executors.newSingleThreadExecutor();
    private final ExecutorService EXECUTOR = Executors.newFixedThreadPool(POOL_SIZE);

    public void doAll() throws ExecutionException, InterruptedException {

        Future<Integer> payment = SINGLE_EXECUTOR.submit(this::collectPayment);
        CompletableFuture<Integer> analytics = CompletableFuture.supplyAsync(this::sendAnalystics, EXECUTOR);

        log.info(String.format("Result analytics %d", analytics.get()));

        log.info(String.format("Result payment %d", payment.get()));
        EXECUTOR.shutdown();
        SINGLE_EXECUTOR.shutdown();
    }

    public int collectPayment() {
        try {
            Thread.sleep(10_000);
            return 10_000;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    public int sendAnalystics() {
        try {
            Thread.sleep(1_000);
            return 1_000;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
}
