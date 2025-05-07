package school.faang.bjs27084;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class PotionGathering {
    private static final int GATHERING_TIME = 500;
    private static final int THREAD_COUNT = 3;

    public static void main(String[] args) {
        List<Potion> potions = List.of(
                new Potion("Healing Potion", 5),
                new Potion("Mana Potion", 3),
                new Potion("Stamina Potion", 4)
        );
        gatherAllIngredients(potions);
    }

    public static int gatherIngredients(Potion potion) {
        try {
            System.out.println("Идет процесс сбора " + potion.getName());
            Thread.sleep(potion.getRequiredIngredients() * GATHERING_TIME);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Ошибка сбора " + potion.getName());
        }
        return potion.getRequiredIngredients();
    }

    public static void gatherAllIngredients(List<Potion> potions) {
        ExecutorService executor = Executors.newFixedThreadPool(THREAD_COUNT);
        AtomicInteger totalIngredients = new AtomicInteger(0);

        List<CompletableFuture<Void>> futures = potions.stream()
                .map(potion -> CompletableFuture
                        .supplyAsync(() -> gatherIngredients(potion), executor)
                        .thenAccept(totalIngredients::addAndGet))
                .toList();

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[futures.size()])).join();
        executor.shutdown();
        System.out.println("Кол-во собранных ингредиентов " + totalIngredients);
    }
}
