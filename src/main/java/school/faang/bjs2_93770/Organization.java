package school.faang.bjs2_93770;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

@Slf4j
public class Organization {
    private static final int NUM_THREADS = 3;
    private static final int TIMEOUT_IN_SECONDS = 10;

    private final AtomicReference<Double> totalAmount = new AtomicReference<>(0.0);
    private final ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);

    public CompletableFuture<Donation> addDonation(Donation donation) {
        return CompletableFuture.supplyAsync(() -> {
            totalAmount.updateAndGet(amount -> amount + donation.getAmount());
            log.info("Внесены пожертвования на сумму {} рублей", donation.getAmount());
            return donation;
        }, executorService);
    }

    public void printTotalAmount() {
        log.info("Общая сумма пожертвований: {}", totalAmount);
    }

    public void shutdownCorrectly() {
        executorService.shutdown();
        try {
            if (executorService.awaitTermination(TIMEOUT_IN_SECONDS, TimeUnit.SECONDS)) {
                log.info("Все задачи выполнены");
            } else {
                log.info("Задачи не успели выполниться");
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.info(e.getMessage());
            executorService.shutdownNow();
        }
    }
}
