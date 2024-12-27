package school.faang.task_50816;

import java.util.List;

public class PotionFactory {
    public static List<Potion> createPotions() {
        return List.of(
                new Potion("Healing Potion", 10),
                new Potion("Mana Potion", 8),
                new Potion("Stamina Potion", 12)
        );
    }
}