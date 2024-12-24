package school.faang.sprint4.task_50781;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Potion> potions = List.of(
                new Potion("Healing Potion", 20),
                new Potion("Mana Potion", 3),
                new Potion("Stamina Potion", 4),
                new Potion("Blindness Potion", 2),
                new Potion("Restore Potion", 1),
                new Potion("Strength Potion", 10)
        );

        PotionCollector potionCollector = new PotionCollector();
        int result = potionCollector.gatherAllIngredients(potions);
        System.out.println("Number of collected ingredients: " + result);
    }
}
