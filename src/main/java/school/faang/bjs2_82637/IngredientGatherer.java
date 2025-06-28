package school.faang.bjs2_82637;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

@Slf4j
@AllArgsConstructor
public class IngredientGatherer {
    private ExecutorService poolThread;

    private static final Random random = new Random();

    public CompletableFuture<Integer> collectIngredients(Potion potion) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(random.nextInt(10));
            } catch (InterruptedException e) {
                log.error("Ошибка сбора ингредиентов", e);
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
            return random.nextInt(1, 10);
        }, poolThread);
    }

    public List<CompletableFuture<Integer>> collectAllIngredients(List<Potion> potions) {
        return potions.stream()
                .map(this::collectIngredients)
                .toList();
    }
}
