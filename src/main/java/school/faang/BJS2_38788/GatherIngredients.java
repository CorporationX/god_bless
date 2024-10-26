package school.faang.BJS2_38788;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class GatherIngredients {
    private static final int THREAD_NUMBERS = 4;
    private static final Logger logger = LoggerFactory.getLogger(GatherIngredients.class);
    private AtomicInteger totalIngredients = new AtomicInteger(0);
    ExecutorService executor = Executors.newFixedThreadPool(THREAD_NUMBERS);

    public GatherIngredients() {
    }

    public CompletableFuture<Integer> gatherIngredients(Potion potion) {
        logger.info("Cбор ингредиентов начался");

        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(4000);
            } catch (Exception e) {
                logger.error("Ошибка при задержке потока {}", Thread.currentThread().getName(), e);
                Thread.currentThread().interrupt();
            }
            return potion.getRequiredIngredients();
        }, executor);
        return future;
    }

    public void gatherAllIngredients(List<Potion> potions) {
        List<CompletableFuture<Integer>> futures = potions.stream()
                .map(potion -> gatherIngredients(potion))
                .toList();
        futures.forEach(future -> totalIngredients.addAndGet(future.join()));

        int total = totalIngredients.get();
        System.out.println("Общее количество собранных ингредиентов: " + total);
    }

    public void shutdown() {
        executor.shutdown();

        try {
            if(!executor.isShutdown()){
                logger.info("Потоки не завершились самостоятельно");
                executor.awaitTermination(20, TimeUnit.SECONDS);
                executor.shutdownNow();
            }
        } catch (Exception e){
            logger.error("Ошибка при завершении пула потоков", e);
        }
    }
}