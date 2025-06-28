package school.faang.bjs2_82675;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class PotionGathering {
    public static void gatherAllIngredients(List<Potion> potions) {
        AtomicInteger total = new AtomicInteger();

        PotionGathering potionGathering = new PotionGathering();

        List<CompletableFuture<Void>> tasks = potions.stream()
                .map(p -> potionGathering.countIngredients(p)
                        .thenAccept(total::addAndGet))
                .toList();

        CompletableFuture<Void> all = CompletableFuture.allOf(tasks.toArray(new CompletableFuture[0]));
        all.join();

        log.info("Общее количество собранных ингредиентов: {}", total.get());
    }

    public CompletableFuture<Integer> countIngredients(Potion potion) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
            log.info("Для зелья {} собрано {} ингредиентов", potion.getName(), potion.getIngredients());
            return potion.getIngredients();
        });
    }
}
