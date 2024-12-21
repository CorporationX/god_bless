package school.faang.task49866;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

@Slf4j
public class MasterCardService {
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
            TimeUnit.SECONDS.sleep(10);
            return 10_000;
        });
    }

    private int sendAnalytics() {
        return handInterrupted(() -> {
            TimeUnit.SECONDS.sleep(5);
            return 5_000;
        });
    }

    public void doAll() {
        ExecutorService service = Executors.newFixedThreadPool(2);

        try {
            Future<Integer> future = service
                    .submit(this::collectPayment);

            CompletableFuture<Integer> completableFuture = CompletableFuture
                    .supplyAsync(this::sendAnalytics, service);

            log.info("Future: {} CompletableFuture: {}", future.get(), completableFuture.get());

            service.shutdown();

            if (service.awaitTermination(20, TimeUnit.SECONDS)) {
                log.info("Платёж выполнен");
            }
        } catch (InterruptedException | ExecutionException e) {
            Thread.currentThread().interrupt();
            log.error("Error message: ", e);
        }
    }
}
