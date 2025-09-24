package school.faang.bjs2_92859;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
public class Potion {
    @Getter
    private String name;
    @Getter
    private int requiredIngredients;
    private static final int COUNT_SLEEP = 1000;

    public int gatherIngredients(Potion potion) {
        try {
            Thread.sleep((long) potion.requiredIngredients * COUNT_SLEEP);
            log.info("Ingredients are being collected...");
        } catch (InterruptedException e) {
            throw new RuntimeException("Something went wrong");
        }
        return potion.requiredIngredients;
    }
}
