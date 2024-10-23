package school.faang.alchemy;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        PotionCollectionService potionService = new PotionCollectionService();
        List<Potion> potions = List.of(
                new Potion("Healing Potion", 15),
                new Potion("Mana Potion", 13),
                new Potion("Stamina Potion", 14)
        );

        potionService.gatherAllIngredients(potions);
        potionService.executorShutdown();
    }
}
