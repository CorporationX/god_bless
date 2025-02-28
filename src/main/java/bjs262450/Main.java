package bjs262450;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Slf4j
public class Main {
    public static void main(String[] args) {
        PotionService potionService = new PotionService();
        List<CompletableFuture<Integer>> ingredientsNumberCf
                = potionService.gatherAllIngredients(initializePotionList());
        CompletableFuture.allOf(ingredientsNumberCf.toArray(new CompletableFuture[0])).join();
        log.info("Общее количество собранных ингредиентов: {}", potionService.getIngredientsNumber().get());
        potionService.shutDownExecutorService();
    }

    private static List<Potion> initializePotionList() {
        return List.of(
                new Potion("Healing Potion", 5),
                new Potion("Mana Potion", 3),
                new Potion("Stamina Potion", 4)
        );
    }
}
