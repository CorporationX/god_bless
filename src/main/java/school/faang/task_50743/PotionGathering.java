package school.faang.task_50743;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
@RequiredArgsConstructor
public class PotionGathering {
    private static final int THREAD_DELAY = 2000;

    private final ExecutorService executorService;

    public int gatherAllIngredients(List<Potion> potions) {
        List<CompletableFuture<Integer>> gatherAllIngredients = potions.stream()
                .map(this::gatherIngredients).toList();

        AtomicInteger totalIngredients = new AtomicInteger(0);

        gatherAllIngredients.forEach(gatherIngredients -> {
            totalIngredients.addAndGet(gatherIngredients.join());
        });

        return totalIngredients.get();
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
}
