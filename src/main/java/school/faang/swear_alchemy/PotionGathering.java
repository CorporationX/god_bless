package school.faang.swear_alchemy;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class PotionGathering {
    public static void main(String[] args) {

        List<Potion> potions = List.of(
                new Potion("Healing", 5),
                new Potion("Mana", 3),
                new Potion("Stamina", 4)
        );

        AtomicInteger totalIngredients = new AtomicInteger(0);

        CompletableFuture<Void> allFutures = CompletableFuture.allOf(
                potions.stream()
                        .map(potion -> CompletableFuture.runAsync(() -> {
                            int gathered = gatherIngredients(potion);
                            totalIngredients.addAndGet(gathered);
                        })).toArray(CompletableFuture[]::new)
        );

        allFutures.join();
        log.info("\nПоздравляю! Все ингредиенты собрались!");
        log.info("Общее количество собранных ингредиентов: {}", totalIngredients.get());
    }

    private static int gatherIngredients(Potion potion) {

        try {
            Thread.sleep(1000L * potion.requiredIngredients());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.info("Сбор прерван для {}", potion.name());
            return 0;
        }

        log.info("Закончился сбор для зелья: {}", potion.name());
        return potion.requiredIngredients();
    }
}
