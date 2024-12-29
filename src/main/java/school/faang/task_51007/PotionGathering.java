package school.faang.task_51007;

import lombok.NonNull;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class PotionGathering {
    public static final int GATHER_TIME = 1000;

    public static void main(String[] args) {
        List<Potion> potions = List.of(
                new Potion("Healing Potion", 5),
                new Potion("Mana Potion", 3),
                new Potion("Stamina Potion", 4)
        );
        gatherAllIngredients(potions);
    }

    private static void gatherAllIngredients(@NonNull List<Potion> potions) {
        AtomicInteger totalIngredients = new AtomicInteger(0);
        int total = potions.stream()
                .map(potion -> CompletableFuture.supplyAsync(() -> {
                    return gatherIngredients(potion);
                }))
                .mapToInt(future -> {
                    totalIngredients.getAndSet(future.join());
                    return totalIngredients.get();
                })
                .sum();

        log.info("Общее количество собранных ингредиентов: {}", total);
    }

    @SneakyThrows
    private static int gatherIngredients(@NonNull Potion potion) {
        Thread.sleep(GATHER_TIME);
        return potion.getRequiredIngredients();
    }
}
