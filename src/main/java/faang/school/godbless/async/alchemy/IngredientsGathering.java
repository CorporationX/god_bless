package faang.school.godbless.async.alchemy;

import java.util.concurrent.CompletableFuture;

public class IngredientsGathering {

    private static final long TIME_MILLI_PER_INGREDIENT = 1000L;

    public CompletableFuture<Integer> gatherIngredientsAsync(Potion potion) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(potion.getRequiredIngredients() * TIME_MILLI_PER_INGREDIENT);
                return potion.getRequiredIngredients();
            } catch (InterruptedException e) {
                throw new RuntimeException("Ingredients gathering was interrupted");
            }
        });
    }
}
