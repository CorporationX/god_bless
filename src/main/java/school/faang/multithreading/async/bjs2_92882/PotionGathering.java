package school.faang.multithreading.async.bjs2_92882;

import java.util.List;

import static school.faang.multithreading.async.bjs2_92882.Potion.gatherAllIngredients;

public class PotionGathering {
    public static void main(String[] args) {
        List<Potion> potions = List.of(
                new Potion("Целебное зелье", 5),
                new Potion("Зелье маны", 3),
                new Potion("Зелье выносливости", 4)
        );

        gatherAllIngredients(potions);
    }
}
