package faang.school.godbless.boostingalchemy;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class IngredientsGatherer {
    public static int gatherIngredients(Potion potion) {
        log.info("Gathering ingredients for '{}'", potion.name());
        try {
            Thread.sleep(potion.requiredIngredients() * 1000L);
        } catch (InterruptedException e) {
            log.error("Gathering ingredients interrupted", e);
            throw new RuntimeException(e);
        }
        log.info("Gathered ingredients for '{}'", potion.name());
        return potion.requiredIngredients();
    }
}