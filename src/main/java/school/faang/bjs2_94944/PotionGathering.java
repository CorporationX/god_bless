package school.faang.bjs2_94944;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class PotionGathering {
    private static final int THREAD_COUNT = 5;
    private static final int SLEEP_TIME = 1000;
    private final ExecutorService executorService = Executors.newFixedThreadPool(THREAD_COUNT);

    public CompletableFuture<Integer> gatherIngredients(Potion potion, ExecutorService executorService) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                System.out.printf("Gathering ingredients for potion %s\n", potion.name());
                Thread.sleep(SLEEP_TIME);
                System.out.printf("Gathered %d ingredients for potion %s\n",
                        potion.requiredIngredients(),
                        potion.name());
                return potion.requiredIngredients();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException("Gathering ingredients was interrupted for potion " + potion.name(), e);
            }
        }, executorService);
    }

    public void gatherAllIngredients(List<Potion> potions) {
        AtomicInteger totalIngredients = new AtomicInteger(0);
        List<CompletableFuture<Void>> futures = potions.stream()
                .map(potion -> gatherIngredients(potion, executorService)
                        .thenAccept(totalIngredients::addAndGet))
                .toList();
        CompletableFuture<Void> allFinished = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));
        allFinished.join();
        System.out.printf("Gathered ingredients count: %d\n", totalIngredients.get());
        executorService.shutdown();
    }
}
