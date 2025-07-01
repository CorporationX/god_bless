package school.faang.bjs2_82692;

import java.util.concurrent.CompletableFuture;

public record Potion(String name, int countIngredients) {
    private static final long MS_IN_S = 1000;

    public CompletableFuture<Integer> collectingIngredients() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(countIngredients * MS_IN_S);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new IllegalStateException(e.getMessage());
            }
            return countIngredients;
        });
    }
}