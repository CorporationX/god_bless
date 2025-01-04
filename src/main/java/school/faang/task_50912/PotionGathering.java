package school.faang.task_50912;

import java.util.List;

import static school.faang.task_50912.Potion.gatherAllIngredients;

public class PotionGathering {
    public static void main(String[] args) {
        List<Potion> potions = List.of(
                new Potion("Healing Potion", 5),
                new Potion("Mana Potion", 3),
                new Potion("Stamina Potion", 4)
        );

        gatherAllIngredients(potions);

        System.out.println("Potion gathering completed!");
    }
}