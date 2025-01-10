package school.faang.bjs250902;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
@Getter
public class Gathering {
    private static final long GATHERING_TIME = 3000L;
    private static final int INIT_NUMBER = 0;
    private static final int THREAD_AMOUNT = 4;
    private static final int TIME_OUT = 5;
    private final AtomicInteger totalNumberOfIngredients = new AtomicInteger(INIT_NUMBER);
    private final ExecutorService executorService = Executors.newFixedThreadPool(THREAD_AMOUNT);

    public CompletableFuture<Integer> gatherIngredients(Potion potion) {
        return CompletableFuture.supplyAsync(() -> {

            log.info("The gathering of ingredients has begun");
            gatherProcess();

            return potion.requiredIngredients();
        }, executorService);
    }

    private static void gatherProcess() {
        try {
            Thread.sleep(GATHERING_TIME);
        } catch (InterruptedException e) {
            log.error("The tread {} was interrupted", Thread.currentThread().getName());
            Thread.currentThread().interrupt();
        }
    }

    public void shutdownExecutorService() {
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(TIME_OUT, TimeUnit.SECONDS)) {
                log.info("The tasks were not completed in 5 seconds, stoped the ThreadPool forcefully");
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("The main thread {} was interrupted while waiting",
                    Thread.currentThread().getName());
            Thread.currentThread().interrupt();
        }
    }
}