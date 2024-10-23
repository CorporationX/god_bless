package school.faang.godbless.bjs2_38746;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GatheringService {
    private static final int WAIT_PER_INGREDIENT = 1000;

    public int gatherIngredients(Potion potion) {
        try {
            Thread.sleep((long) potion.getRequiredIngredients() * WAIT_PER_INGREDIENT);
            return potion.getRequiredIngredients();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("Thread {} was interrupted when gathering ingredients", Thread.currentThread().getName());
            return 0;
        }
    }
}
