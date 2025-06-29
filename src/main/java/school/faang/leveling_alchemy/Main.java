package school.faang.leveling_alchemy;

import java.util.List;

import static school.faang.leveling_alchemy.PotionGathering.gatherAllIngredients;

public class Main {
    public static void main(String[] args) {
        List<Potion> potions = List.of(
                new Potion("Healing Potion", 5),
                new Potion("Mana Potion", 3),
                new Potion("Stamina Potion", 4)
        );

        gatherAllIngredients(potions);
    }
}
