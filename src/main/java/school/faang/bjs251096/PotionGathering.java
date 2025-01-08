package school.faang.bjs251096;

import java.util.List;

public class PotionGathering {
    public static void main(String[] args) {
        GatherOfIngredients gather = new GatherOfIngredients();

        List<Potion> potions = List.of(
                new Potion("Healing Potion", 5),
                new Potion("Mana Potion", 3),
                new Potion("Stamina Potion", 4),
                new Potion("Strength Potion", 6),
                new Potion("Speed Potion", 2),
                new Potion("Invisibility Potion", 7),
                new Potion("Fire Resistance Potion", 4),
                new Potion("Water Breathing Potion", 3),
                new Potion("Night Vision Potion", 5),
                new Potion("Regeneration Potion", 6)
        );

        gather.gatherAllIngredients(potions);
    }
}

