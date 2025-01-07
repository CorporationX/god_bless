package school.faang.sprint_4.task_51086;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicInteger;

public class PotionGathering {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<Potion> potions = List.of(
                new Potion("Healing Potion", 5),
                new Potion("Mana Potion", 3),
                new Potion("Stamina Potion", 4)
        );

        gatherAllIngredients(potions);
    }

    private static void gatherAllIngredients(List<Potion> potions) throws ExecutionException, InterruptedException {
        List<CompletableFuture<Integer>> futures = potions.stream()
                .map(potion -> CompletableFuture.supplyAsync(() -> gatherIngredients(potion)))
                .toList();

        CompletableFuture<Void> all = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));
        all.get();

        AtomicInteger totalIngredients = new AtomicInteger(0);
        futures.forEach(future -> totalIngredients.addAndGet(future.join()));
        System.out.println("Общее количестов собранных ингредиентов: " + totalIngredients.get());
    }

    private static int gatherIngredients(Potion potion) {
        try {
            Thread.sleep(1000L * potion.requiredIngredients());
            return potion.requiredIngredients();
        } catch (InterruptedException e) {
            System.out.println("Поток " + Thread.currentThread().getName() + " прервал работу");
            return -1;
        }
    }
}
