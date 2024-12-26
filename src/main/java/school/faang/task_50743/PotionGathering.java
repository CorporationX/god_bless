package school.faang.task_50743;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class PotionGathering {
    private static final int DELAY_BEFORE_TERMINATION = 30;
    private static final int NUM_THREADS = 5;
    private static final int THREAD_DELAY = 2000;

    private final ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);

    public CompletableFuture<Integer> gatherAllIngredients(List<Potion> potions) {
        return potions.stream()
                .map(this::gatherIngredients)
                .reduce(CompletableFuture.completedFuture(0),
                        (future1, future2) -> {
                            return future1.thenCombine(future2, Integer::sum);
                        });
    }

    private CompletableFuture<Integer> gatherIngredients(Potion potion) {
        return CompletableFuture.supplyAsync(() -> {
            log.info("The process of collecting the ingredients from the potion has begun {}", potion.getName());
            try {
                Thread.sleep(THREAD_DELAY);
            } catch (InterruptedException e) {
                log.error(e.getMessage());
            }
            return potion.getRequiredIngredients();
        }, executorService);
    }

    public void terminate() {
        executorService.shutdown();
        try {
            if (executorService.awaitTermination(DELAY_BEFORE_TERMINATION, TimeUnit.SECONDS)) {
                log.info("All tasks successfully completed");
            } else {
                log.info("Tasks not completed");
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.info(e.getMessage());
        }
    }
}
