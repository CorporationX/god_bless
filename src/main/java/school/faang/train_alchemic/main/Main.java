package school.faang.train_alchemic.main;

import school.faang.train_alchemic.main_code.Potion;
import school.faang.train_alchemic.main_code.PotionService;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        PotionService potionService = new PotionService();

        List<Potion> potions = List.of(
                new Potion("Healing Potion", 5),
                new Potion("Mana Potion", 3),
                new Potion("Stamina Potion", 4)
        );

        potionService.getAllIngredients(potions);
    }
}
