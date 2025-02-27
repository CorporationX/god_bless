package school.faang.improvealchemy;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class PotionGathering {
    private static final List<Potion> POTIONS = List.of(
            new Potion("Healing Potion", 5),
            new Potion("Mana Potion", 3),
            new Potion("Stamina Potion", 4)
    );
    private static final int COLLECTING_TIME_PER_ONE_INGREDIENT = 1000;
    private static final AtomicInteger TOTAL_INGREDIENTS = new AtomicInteger(0);

    public static void main(String[] args) {
        List<CompletableFuture<Void>> futurePotions = POTIONS.stream()
                .map(potion -> CompletableFuture
                        .supplyAsync(() -> gatherAllIngredients(potion))
                        .thenAccept(TOTAL_INGREDIENTS::addAndGet)
                        .thenRun(() -> log.info("{} ingredients for potion {} collected",
                                potion.requiredIngredients(), potion.name())))
                .toList();

        CompletableFuture.allOf(futurePotions.toArray(CompletableFuture[]::new)).join();
        log.info("Total ingredients: {}", TOTAL_INGREDIENTS.get());
    }

    private static int gatherAllIngredients(Potion potion) {
        Objects.requireNonNull(potion, "Invalid potion value");
        try {
            Thread.sleep((long) potion.requiredIngredients() * COLLECTING_TIME_PER_ONE_INGREDIENT);
        } catch (InterruptedException e) {
            log.error("Async tasks failed. Exception: {}\nStack trace: {}", e, e.getStackTrace());
        }
        return potion.requiredIngredients();
    }
}
