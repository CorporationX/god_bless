package school.faang.task49866;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

@Slf4j
public class MasterCardService {
    private static final int COLLECT_SECONDS = 10;
    private static final int COLLECT_PAYMENT = 10_000;
    private static final int ANALYTICS_SECONDS = 5;
    private static final int ANALYTICS_PAYMENT = 5_000;
    private static final int THREAD_COUNT = 2;
    private static final int AWAIT_TERMINATION = 20;

    private int handInterrupted(HandInterrupted<Integer> interrupted) {
        try {
            return interrupted.test();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("Error message: ", e);
        }
        return 0;
    }

    private int collectPayment() {
        return handInterrupted(() -> {
            TimeUnit.SECONDS.sleep(COLLECT_SECONDS);
            return COLLECT_PAYMENT;
        });
    }

    private int sendAnalytics() {
        return handInterrupted(() -> {
            TimeUnit.SECONDS.sleep(ANALYTICS_SECONDS);
            return ANALYTICS_PAYMENT;
        });
    }

    public void doAll() {
        ExecutorService service = Executors.newFixedThreadPool(THREAD_COUNT);

        try {
            Future<Integer> future = service
                    .submit(this::collectPayment);

            CompletableFuture<Integer> completableFuture = CompletableFuture
                    .supplyAsync(this::sendAnalytics, service);

            log.info("Future: {} CompletableFuture: {}", future.get(), completableFuture.get());

            service.shutdown();

            if (service.awaitTermination(AWAIT_TERMINATION, TimeUnit.SECONDS)) {
                log.info("Платёж выполнен");
            }
        } catch (InterruptedException | ExecutionException e) {
            Thread.currentThread().interrupt();
            log.error("Error message: ", e);
        }
    }
}
