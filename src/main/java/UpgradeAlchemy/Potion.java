package UpgradeAlchemy;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

import java.util.concurrent.CompletableFuture;

@Getter
@AllArgsConstructor
public class Potion {
    private String name;
    private int requiredIngredients;

    public int gatherIngredients(@NonNull Potion potion) {
        CompletableFuture<Void> ingredients = CompletableFuture
                .runAsync(() -> {
                    try {
                        Thread.sleep(1000L * potion.requiredIngredients);
                    } catch (InterruptedException e) {
                        System.err.println("Thread was interrupted: " + e.getMessage());
                    }
                });
        return potion.getRequiredIngredients();
    }
}
