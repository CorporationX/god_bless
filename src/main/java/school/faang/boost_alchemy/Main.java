package school.faang.boost_alchemy;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Potion> potions = List.of(
                new Potion("Healing Potion", 5),
                new Potion("Mana Potion", 3),
                new Potion("Stamina Potion", 4),

                new Potion("Super Potion", 9),
                new Potion("Dead Potion", 8),
                new Potion("Philtre Potion", 6)
        );

        PotionMaker potionMaker = new PotionMaker();
        potionMaker.countAllIngredients(potions);

        int sum = potionMaker.getTotalIngredients().get();
        System.out.println(sum);

    }
}
