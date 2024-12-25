package school.faang.task_50753;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int THREAD_POOL_SIZE = 3;
    private static final int AWAIT_TERMINATION_TIME = 60;

    public static void main(String[] args) {
        List<Potion> potions = List.of(
                new Potion("Healing Potion", 5),
                new Potion("Mana Potion", 3),
                new Potion("Stamina Potion", 4)
        );

        PotionService service = new PotionService();
        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
        service.gatherAllIngredients(potions, executorService);
        System.out.println("Ждем пока посчитается totalIngredients!");

        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(AWAIT_TERMINATION_TIME, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
        }
    }
}
