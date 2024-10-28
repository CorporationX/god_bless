package school.faang.alchemyGrind;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class PotionGathering {
    final int THREADS = 5;
    private ExecutorService executor = Executors.newFixedThreadPool(THREADS);

    public CompletableFuture<Integer> gatherIngredients(Potion potion) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                log.info(potion.getName() + " сбор ингредиентов");
                Thread.sleep(potion.getRequireIngredients() * 500L);
                executor.shutdown();
            } catch (InterruptedException e) {
                log.error(potion.getName() + " сбор ингредиентов прерван.");
                throw new RuntimeException(e);
            }
            return potion.getRequireIngredients();
        }, executor);
    }

    public void gatherAllIngredients(List<Potion> potions){
        AtomicInteger totalIngredients = new AtomicInteger(0);
        List<CompletableFuture<Integer>> futures = potions.stream().map(this::gatherIngredients).toList();
        futures.forEach(future -> totalIngredients.addAndGet(future.join()));
        System.out.println("Общее количество собранных ингредиентов: " + totalIngredients.get());
    };
}
