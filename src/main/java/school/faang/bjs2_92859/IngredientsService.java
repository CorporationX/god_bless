package school.faang.bjs2_92859;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class IngredientsService {
    private static final int COUNT_SLEEP = 1000;

    public int gatherIngredients(Potion potion) {
        try {
            Thread.sleep((long) potion.getRequiredIngredients() * COUNT_SLEEP);
            log.info("Ingredients are being collected...");
        } catch (InterruptedException e) {
            throw new RuntimeException("Something went wrong");
        }
        return potion.getRequiredIngredients();
    }
}
