package school.faang.bjs2_94700;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class PotionGatherer {
    private static final int NUM_THREADS = 5;
    private static final int GATHERING_TIME_IN_MS = 5000;
    private static final int TIMEOUT_IN_SECONDS = 10;
    private ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);

    public CompletableFuture<Integer> gatherIngredients(Potion potion) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                log.info("Начинаем сбор ингредиентов для зелья {}", potion.getName());
                Thread.sleep(GATHERING_TIME_IN_MS);
            } catch (InterruptedException e) {
                log.error(e.getMessage());
                Thread.currentThread().interrupt();
            }
            return potion.getAmountOfRequiredIngredients();
        }, executorService);
    }

    public void shutdownCorrectly() {
        executorService.shutdown();
        try {
            if (executorService.awaitTermination(TIMEOUT_IN_SECONDS, TimeUnit.SECONDS)) {
                log.info("Все ингредиенты собраны");
            } else {
                log.warn("Не все ингредиенты успели собрать за отведенное время");
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error(e.getMessage());
            executorService.shutdownNow();
        }
    }
}
