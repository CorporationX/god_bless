package school.faang.Sprints.Multithreading_Async.downloading_alchemy;

import java.util.List;

import static school.faang.Sprints.Multithreading_Async.downloading_alchemy.PotionService.gatherAllIngredients;

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
