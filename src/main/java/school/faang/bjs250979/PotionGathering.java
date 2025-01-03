package school.faang.bjs250979;

import java.lang.reflect.Array;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class PotionGathering {
    public static void main(String[] args) {
        List<Potion> potions = List.of(
                new Potion("Healing Potion", 5),
                new Potion("Mana Potion", 3),
                new Potion("Stamina Potion", 4)
        );

        gatherAllIngredients(potions);
    }

    private static void gatherAllIngredients(List<Potion> potions) {
        CompletableFuture<Void>[] potionsFutures= potions.stream()
                .map(potion -> {
                    return new CompletableFuture<Void>(() -> {

                    });
                })
                .toArray();

        //CompletableFuture[] potionsFutures = new CompletableFuture[potions.size()];
        CompletableFuture.allOf(potionsFutures);
    }
}
