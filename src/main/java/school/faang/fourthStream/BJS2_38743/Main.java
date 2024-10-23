package school.faang.fourthStream.BJS2_38743;

import java.util.List;

import static school.faang.fourthStream.BJS2_38743.PotionCollector.gatherAllIngredients;

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
