package faang.school.godbless.alchimie;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    private final static int NUM_OF_POTIONS = 100;

    public static void main(String[] args) {
        Random random = new Random();

        List<Potion> potions = new ArrayList<>();
        for (int i = 0; i < NUM_OF_POTIONS; i++) {
            potions.add(new Potion(Integer.toString(i), random.nextInt(1, 5)));
        }

        ExecutorService service = Executors.newFixedThreadPool(NUM_OF_POTIONS);

        AtomicInteger sum = new AtomicInteger(0);


        CompletableFuture<?> allFutures = CompletableFuture.allOf(potions.stream()
                .map(potion -> CompletableFuture.supplyAsync(() -> {
                    try {
                        return sum.addAndGet(gatherIngredients(potion));
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }, service))
                .toList().toArray(new CompletableFuture[0])
        );

        allFutures.thenRun(
                () -> System.out.println(sum)
        );

        service.shutdown();
    }

    private static int gatherIngredients(Potion potion) throws InterruptedException {
        Thread.sleep(1000L * potion.getRequiredIngredients());
        return potion.getRequiredIngredients();
    }
}
