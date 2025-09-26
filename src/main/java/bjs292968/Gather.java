package bjs292968;

import java.util.concurrent.CompletableFuture;

public class Gather {
    public static CompletableFuture<Integer> gatherFuture(Potion potion) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000);

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
                throw new RuntimeException();
            }
            System.out.println(potion.name() + " gathered!");
            return potion.amountIngredients();
        });
    }
}
