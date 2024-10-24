package school.faang.alchemy;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Potion> potions = List.of(
                new Potion("Healing Potion", 5),
                new Potion("Mana Potion", 3),
                new Potion("Stamina Potion", 4)
        );
        PotionMaker potionMaker = new PotionMaker(3);
        potionMaker.gatherAllIngredients(potions);
        potionMaker.shutdownExecutorService();
    }
}