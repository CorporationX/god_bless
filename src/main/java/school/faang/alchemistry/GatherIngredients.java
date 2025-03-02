package school.faang.alchemistry;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GatherIngredients {
    public int gatherIngredients(Potion potion) {
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            log.error("Thread was interrupted", e);
        }
        return potion.getRequiredIngredients();
    }
}
