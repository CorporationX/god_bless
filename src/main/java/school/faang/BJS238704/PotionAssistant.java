package school.faang.BJS238704;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class PotionAssistant {
    private static final int THREADS = 2;
    private static final ExecutorService EXECUTOR_SERVICE = Executors.newFixedThreadPool(THREADS);
    private static final AtomicInteger total = new AtomicInteger(0);

    public void gatherIngredients(Potion potion) {
        System.out.println("Сбор ингредиентов для: " + potion.getName());
        int ingredientsCount = potion.getRequiredIngredients();
            try {
                Thread.sleep(5000);
                log.info("ингредиенты собраны для зелья {}. Количество ингредиентов: {}", potion.getName(), ingredientsCount);
                total.addAndGet(ingredientsCount);
            } catch (InterruptedException e) {
                log.error("Что-то пошло не так " + e);
            }
    }

    public void collectAllIngredients(List<Potion> potions) {
        List<CompletableFuture<Void>> futures = potions.stream()
                .map(potion -> CompletableFuture.runAsync(() -> gatherIngredients(potion), EXECUTOR_SERVICE))
                .toList();

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]))
                .thenRun(() -> System.out.println("Общее количество ингредиентов: " + total.get()));
    }

    public void shutDown() {
        EXECUTOR_SERVICE.shutdown();
    }
}
