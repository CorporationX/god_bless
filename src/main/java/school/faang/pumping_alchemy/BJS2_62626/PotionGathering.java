package school.faang.pumping_alchemy.BJS2_62626;

import lombok.NonNull;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class PotionGathering {
    private final IngredientPicker ingredientPicker = new IngredientPicker();

    public List<CompletableFuture<Integer>> gatherAllIngredients(@NonNull List<Potion> potions) {
        return potions.stream()
                .map(ingredientPicker::gatherIngredients)
                .toList();
    }

}
