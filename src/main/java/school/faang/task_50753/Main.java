package school.faang.task_50753;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    private static final int THREAD_POOL_SIZE = 3;
    public static void main(String[] args) {
        List<Potion> potions = List.of(
                new Potion("Healing Potion", 5),
                new Potion("Mana Potion", 3),
                new Potion("Stamina Potion", 4)
        );

        PotionService service = new PotionService();
        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
        service.gatherAllIngredients(potions, executorService);
    }
}
