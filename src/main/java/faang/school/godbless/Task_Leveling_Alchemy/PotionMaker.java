package faang.school.godbless.Task_Leveling_Alchemy;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.

public class PotionMaker {

    public int gatherIngredients(Potion potion) {
        ExecutorService potionService = Executors.newFixedThreadPool(potion.getRequiredIngredients());
        List<CompletableFuture<Void>> futures = new ArrayList<>();
        for (int i = 0; i < potion.getRequiredIngredients(); i++) {
            int index = i;
            CompletableFuture<Void> numberOfIngredients = CompletableFuture.runAsync(() -> {
                System.out.println("creating potion number " + index);
            }, potionService);
            futures.add(numberOfIngredients);
        }
        CompletableFuture[] futureResult = futures.toArray(new CompletableFuture[futures.size()]);
        CompletableFuture<Void> combinedResult = CompletableFuture.allOf(futureResult);
        System.out.println("All potions were prepared");
        return potion.getRequiredIngredients();
    }

}
