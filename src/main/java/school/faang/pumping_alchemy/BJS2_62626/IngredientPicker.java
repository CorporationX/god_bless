package school.faang.pumping_alchemy.BJS2_62626;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;

@Slf4j
public class IngredientPicker {
    private static final int ASSEMBLY_TIME_OF_ONE_INGREDIENT = 1000;

    public CompletableFuture<Integer> gatherIngredients(@NonNull Potion potion) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep((long) potion.requiredIngredients() * ASSEMBLY_TIME_OF_ONE_INGREDIENT);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                log.warn("Задача прервана {}", e.getMessage());
            }
            return potion.requiredIngredients();
        });
    }
}
