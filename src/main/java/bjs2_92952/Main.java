package bjs2_92952;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Potion> potions = List.of(
                new Potion("Зелье лечения", 5),
                new Potion("Зелье маны", 3),
                new Potion("Зелье выносливости", 4),
                new Potion("Зелье ловкости", 3)
        );

        PotionGathering.gatherAllIngredients(potions);
    }
}
