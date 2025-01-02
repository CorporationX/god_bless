package school.faang.task_51135;

import java.util.List;

public class PotionGathering {

    public static void main(String[] args) {
        GatheringSystem gatheringSystem = new GatheringSystem();

        final List<Potion> potions = List.of(
                new Potion("Healing Potion", 5),
                new Potion("Mana Potion", 3),
                new Potion("Stamina Potion", 4)
        );

        gatheringSystem.gatherAllIngredients(potions);
    }
}