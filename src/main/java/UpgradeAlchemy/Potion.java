package UpgradeAlchemy;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.concurrent.CompletableFuture;

@Getter
@AllArgsConstructor
public class Potion {
    private String name;
    private int requiredIngredients;

    public int gatherIngredients(Potion potion) {
        CompletableFuture<Void> ingredients = CompletableFuture
                .runAsync(() -> {
                    try {
                        Thread.sleep(1000L * potion.requiredIngredients);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                });
        return potion.getRequiredIngredients();
    }
}
