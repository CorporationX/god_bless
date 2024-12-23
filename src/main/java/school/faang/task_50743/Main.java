package school.faang.task_50743;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static final int NUM_THREADS = 3;

    public static void main(String[] args) {
        log.info("Started");

        List<Potion> potions = List.of(
                new Potion("Healing Potion", 5),
                new Potion("Mana Potion", 3),
                new Potion("Stamina Potion", 4)
        );

        ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);

        PotionGathering potionGathering = new PotionGathering(executorService);

        log.info("Total number of ingredients collected: {}", potionGathering.gatherAllIngredients(potions));

        executorService.shutdown();
        try {
            if (executorService.awaitTermination(30, TimeUnit.SECONDS)) {
                log.info("All tasks successfully completed");
            } else {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error(e.getMessage());
        }
    }
}
