package school.faang.pumping_alchemy;

import java.util.List;

/**
 * Проект: god_bless
 * Класс PotionGatheringApp
 * Автор: Vital
 */

public class PotionGatheringApp {

    public static void main(String[] args) {
        List<Potion> potions = List.of(
                new Potion("Целебное зелье", 5),
                new Potion("Зелье маны", 3),
                new Potion("Зелье выносливости", 4)
        );

        PotionCollector collector = new PotionCollector();
        collector.gatherAllIngredients(potions);
    }
}