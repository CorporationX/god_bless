package school.faang.bjs2_82675;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Potion> potions = List.of(
                new Potion("фляга с эстусом", 5),
                new Potion("мана", 3),
                new Potion("чудесное снадобье", 2)
        );

        PotionGathering.gatherAllIngredients(potions);
    }
}
