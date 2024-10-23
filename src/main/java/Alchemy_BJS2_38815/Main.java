package Alchemy_BJS2_38815;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Potion> potions = List.of(
                new Potion("Healing Potion", 5),
                new Potion("Mana Potion", 3),
                new Potion("Stamina Potion", 4)
        );

        Potion.gatherAllIngredients(potions);
    }
}