package school.faang.task_51115;

import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        PotionGathering potionGathering = new PotionGathering();
        List<Potion> potions = List.of(
                new Potion("Healing Potion", 5),
                new Potion("Mana Potion", 3),
                new Potion("Stamina Potion", 4)
        );

        System.out.println("All ingredients was collected: " + potionGathering.gatherIngredients(potions));
    }
}
