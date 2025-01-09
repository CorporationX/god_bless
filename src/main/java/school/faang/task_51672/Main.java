package school.faang.task_51672;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.Executors;

@Slf4j
public class Main {
    private static final int NUM_THREADS = 10;
    private static final long LEAD_TIME = 30;

    public static void main(String[] args) {
        IngredientCollector collector = new IngredientCollector(
                Executors.newFixedThreadPool(NUM_THREADS)
        );
        List<Potion> potions = List.of(
                new Potion("Healing Potion", 3),
                new Potion("Mana Potion", 2),
                new Potion("Strength Potion", 4),
                new Potion("Invisibility Potion", 5),
                new Potion("Speed Potion", 2),
                new Potion("Antidote", 1)
        );

        int result = collector.gatherAllIngredients(potions).join();

        log.info("A total of {} ingredients have been collected", result);
        collector.finishCollecting(LEAD_TIME);
    }
}
