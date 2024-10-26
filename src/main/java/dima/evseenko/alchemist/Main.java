package dima.evseenko.alchemist;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        PotionService potionService = new PotionService();
        potionService.gatherAllIngredients(getPotions());
    }

    private static List<Potion> getPotions() {
        return List.of(
                new Potion("Healing Potion", 5),
                new Potion("Mana Potion", 3),
                new Potion("Stamina Potion", 4)
        );
    }
}
