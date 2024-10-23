package school.faang.task414;

import school.faang.task414.potion.Potion;

import java.util.List;

import static school.faang.task414.potion.PotionGathering.gatherAllIngredients;

public class Main {
    public static void main(String[] args) {
        List<Potion> potions = List.of(
                new Potion("Healing Potion", 5),
                new Potion("Mana Potion", 3),
                new Potion("Stamina Potion", 4)
        );

        // Асинхронный сбор ингредиентов
        gatherAllIngredients(potions);
    }
}
