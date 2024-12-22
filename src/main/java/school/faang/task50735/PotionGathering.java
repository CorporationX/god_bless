package school.faang.task50735;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class PotionGathering {
    private static final int TIME_SLEEP = 2;

    public static void main(String[] args) {
        List<Potion> potions = List.of(
                new Potion("Healing Potion", 5),
                new Potion("Mana Potion", 3),
                new Potion("Stamina Potion", 4)
        );

        AtomicInteger sum = new AtomicInteger(0);

        CompletableFuture.allOf(
                        potions.stream()
                                .parallel()
                                .map(potion ->
                                        CompletableFuture.supplyAsync(() ->
                                                sum.getAndAdd(gatheringAllIngredients(potion))))
                                .toArray(CompletableFuture[]::new))
                .thenRun(() -> log.info("Общее количество ингредиентов: {}", sum.intValue()))
                .join();
    }

    private static int gatheringAllIngredients(Potion potion) {

        try {
            TimeUnit.SECONDS.sleep(TIME_SLEEP);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("Сбор ингредиентов прерван", e);
        }
        return potion.ingredients();
    }
}
