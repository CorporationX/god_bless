package school.faang.bjs251106;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        PotionGathering potionGathering = new PotionGathering();

        List<Potion> potions = List.of(
                new Potion("Healing Potion", 5),
                new Potion("Mana Potion", 3),
                new Potion("Stamina Potion", 4)
        );

        potionGathering.gatherAllIngredients(potions);
    }
}
