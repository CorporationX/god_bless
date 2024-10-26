package school.faang.alchemyGrind;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        PotionGathering potionGathering = new PotionGathering();
        List<Potion> potions = new ArrayList<>(List.of(
                new Potion("лечения", 5), new Potion("выносливости", 3),
                new Potion("невидимости", 4), new Potion("магии", 3),
                new Potion("исцеления болезней", 5)
        ));

        potionGathering.gatherAllIngredients(potions);
    }
}
