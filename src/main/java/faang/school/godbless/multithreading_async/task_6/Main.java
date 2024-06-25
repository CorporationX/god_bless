package faang.school.godbless.multithreading_async.task_6;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        final PotionIngredientCollector potionIngredientCollector = new PotionIngredientCollector();
        final List<Potion> potions = getPotions();
        final ExecutorService executor = Executors.newFixedThreadPool(potions.size());
        potionIngredientCollector.gatherAllIngredients(potions, executor);
        executor.shutdown();
    }

    private static List<Potion> getPotions() {
        final List<Potion> potions = new ArrayList<>();
        potions.add(new Potion("Polyjuice Potion", 10));
        potions.add(new Potion("Felix Felicis", 5));
        potions.add(new Potion("Amortentia", 8));
        potions.add(new Potion("Veritaserum", 6));
        potions.add(new Potion("Draught of Living Death", 12));
        potions.add(new Potion("Skele-Gro", 9));
        potions.add(new Potion("Wolfsbane Potion", 7));
        potions.add(new Potion("Pepperup Potion", 4));
        potions.add(new Potion("Elixir of Life", 15));
        return potions;
    }
}
