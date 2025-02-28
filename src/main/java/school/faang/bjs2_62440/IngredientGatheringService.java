package school.faang.bjs2_62440;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

@Slf4j
public class IngredientGatheringService {
    public static int gatherIngredients(Potion potion) {
        try {
            TimeUnit.SECONDS.sleep(potion.getRequiredIngredients());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.warn("Ingredient gathering interrupted for potion: {}", potion.getName());
            return 0;
        }
        return potion.getRequiredIngredients();
    }
}
