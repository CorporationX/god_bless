package school.faang.bjs2_92943;

import java.util.concurrent.CompletableFuture;

public class PotionGathering {

    public CompletableFuture<Integer> gatherIngredients(Potion potion) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                System.out.printf("Gathering of ingredients started for potion %s%n", potion.getName());
                Thread.sleep(2000);
                System.out.printf("Gathering of ingredients completed for potion %s%n", potion.getName());
            } catch (InterruptedException e) {
                throw new RuntimeException("Potion gathering was interrupted: " + e);
            }
            return potion.getRequiredIngredients();
        });
    }
}