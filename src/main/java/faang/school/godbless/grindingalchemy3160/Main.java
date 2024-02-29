package faang.school.godbless.grindingalchemy3160;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    static final List<Potion> POTIONS = createPotionsList();
    static final ExecutorService EXECUTOR = Executors.newCachedThreadPool();
    static AtomicInteger totalIngredientsGathered = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        List<CompletableFuture<Integer>> futureTotalIngredients = POTIONS.stream()
                .map(potion -> CompletableFuture.supplyAsync(() -> gatherIngredients(potion), EXECUTOR))
                .toList();
        CompletableFuture.allOf(futureTotalIngredients.toArray(CompletableFuture[]::new));
        futureTotalIngredients.forEach(future -> EXECUTOR.execute(() -> countTotalIngredientsGathered(future)));
        EXECUTOR.shutdown();
        EXECUTOR.awaitTermination(20L, TimeUnit.SECONDS);
        System.out.printf("Number of total ingredients gathered is: %d", totalIngredientsGathered.get());
    }

    public static int gatherIngredients(Potion potion) {
        System.out.printf("Gathering ingredients for %s. It might take some time...%n", potion.getName());
        threadSleep(potion.getRequiredIngredients() * 2500L);
        System.out.printf("%s is ready to make. You gathered all %d ingredients you need%n",
                potion.getName(), potion.getRequiredIngredients());
        return potion.getRequiredIngredients();
    }

    private static List<Potion> createPotionsList() {
        return new ArrayList<>(List.of(
                new Potion("Skooma", 4),
                new Potion("Holy Water", 2),
                new Potion("Stros M'Kai Rom", 2),
                new Potion("Potion of Invisibility", 5),
                new Potion("Vaermina's Torpor", 3)
        ));
    }

    private static void threadSleep(long timeInMillis) {
        try {
            Thread.sleep(timeInMillis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private static void countTotalIngredientsGathered(CompletableFuture<Integer> potionIngredients) {
        try {
            totalIngredientsGathered.addAndGet(potionIngredients.get());
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }
}
