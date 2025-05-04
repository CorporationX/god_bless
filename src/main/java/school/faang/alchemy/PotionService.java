package school.faang.alchemy;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class PotionService {
    private static final int THREAD_POOL = 3;

    public static CompletableFuture<Integer> gatherIngredients(Potion potion, ExecutorService service)
            throws InterruptedException {
        final int countIngredients = potion.requiredIngredients();
        final long threadSleep = 1000;

        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            for (int i = 1; i <= countIngredients; i++) {
                log.info("Начали собирать {} ингридиент для зелья {}", i, potion.name());

                try {
                    Thread.sleep(threadSleep);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    throw new RuntimeException(e);
                }

                log.info("Закончили собирать {} ингридиент для зелья {}", i, potion.name());
            }
            return countIngredients;
        }, service);
        service.shutdown();

        return future;
    }

    public static void gatherAllIngredients(List<Potion> potions) {
        ExecutorService service = Executors.newFixedThreadPool(THREAD_POOL);
        List<CompletableFuture<Integer>> completableFutureList = potions.stream()
                .map(potion -> {
                    try {
                        return gatherIngredients(potion, service);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        throw new RuntimeException(e);
                    }
                })
                .toList();

        for (CompletableFuture<Integer> future : completableFutureList) {
            future.join();
        }

        AtomicInteger totalIngredient = new AtomicInteger(0);
        completableFutureList.forEach(future -> future.thenAccept(totalIngredient::addAndGet));

        log.info("Всего было собрано {} ингридиентов", totalIngredient.get());
    }
}
