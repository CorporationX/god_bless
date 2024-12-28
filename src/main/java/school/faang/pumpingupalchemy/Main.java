package school.faang.pumpingupalchemy;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Potion> potions = List.of(
                new Potion("Healing Potion", 5),
                new Potion("Mana Potion", 3),
                new Potion("Stamina Potion", 4)
        );
        PotionGathering.gatherAllIngredients(potions);
    }
}
