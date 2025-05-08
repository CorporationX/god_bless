package school.faang.bjs2_75803;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class PotionService {
    public static final AtomicInteger totalIngredients = new AtomicInteger(0);

    public static CompletableFuture<Integer> gatherIngredients(Potion potion) {
        return CompletableFuture.supplyAsync(() -> {
            log.info("Собираем игредиенты для зелья {}", potion.getName());
            try {
                TimeUnit.SECONDS.sleep(potion.getRequiredIngredient());
            } catch (InterruptedException e) {
                log.error(e.getMessage());
                throw new RuntimeException(e);
            }
            return potion.getRequiredIngredient();
        }).thenApply(ingredient -> totalIngredients.accumulateAndGet(ingredient, Integer::sum));
    }
}
