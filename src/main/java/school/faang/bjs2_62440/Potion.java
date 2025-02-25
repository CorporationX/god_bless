package school.faang.bjs2_62440;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

@Slf4j
@Getter
@RequiredArgsConstructor
public class Potion {
    private final String name;
    private final int requiredIngredients;

    public static int gatherIngredients(Potion potion) {
        try {
            TimeUnit.SECONDS.sleep(potion.getRequiredIngredients());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.warn("Ingredient gathering interrupted for potion: {}", potion.getName());
        }
        return potion.getRequiredIngredients();
    }
}
