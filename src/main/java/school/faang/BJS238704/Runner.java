package school.faang.BJS238704;

import java.util.List;

public class Runner {
    public static void main(String[] args) {
        List<Potion> potionList = List.of(
                new Potion("Healing Potion", 5),
                new Potion("Mana Potion", 3),
                new Potion("Stamina Potion", 4)
        );

        PotionAssistant potionAssistant = new PotionAssistant();
        potionAssistant.collectAllIngredients(potionList);
        potionAssistant.shutDown();
    }
}
