package school.faang.alchemy;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Potion> listPotions = List.of(new Potion("potion1", 12),
                new Potion("potion2", 5),
                new Potion("potion3", 7),
                new Potion("potion4", 1));

        PotionService.gatherAllIngredients(listPotions);
    }
}
