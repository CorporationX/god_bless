package school.faang.bjs2_92935;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        PotionGathering potion = new PotionGathering();

        List<Potion> potions = List.of(
                new Potion("Healing Potion", 5),
                new Potion("Mana Potion", 3),
                new Potion("Stamina Potion", 4)
        );

        potion.gatherAllIngredients(potions);
    }
}