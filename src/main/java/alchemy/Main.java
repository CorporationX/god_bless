package alchemy;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Potion> potions = List.of(
                new Potion("Healing Potion", 5),
                new Potion("Mana Potion", 3),
                new Potion("Stamina Potion", 4),
                new Potion("Speed Potion", 6),
                new Potion("Strength Potion", 4)
        );

        PotionGathering.gatherAllIngredients(potions);
    }
}
