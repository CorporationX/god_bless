package school.faang.task_50816;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    public static void main(String[] args) {
        ExecutorService executorService = ExecutorServiceFactory.createExecutorService();
        PotionGathering potionGathering = new PotionGathering(executorService);

        List<Potion> potions = PotionFactory.createPotions();

        List<CompletableFuture<Integer>> futures = potions.stream()
                .map(potionGathering::gatherIngredientsAsync)
                .toList();

        CompletableFuture<Void> allTasks = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));

        allTasks.thenRun(() -> {
            int totalIngredients = futures.stream()
                    .map(CompletableFuture::join)
                    .mapToInt(Integer::intValue)
                    .sum();

            log.info("Общее количество собранных ингредиентов: {}", totalIngredients);
        }).join();

        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(10, TimeUnit.SECONDS)) {
                log.warn("Потоки не завершились вовремя. Принудительное завершение.");
                List<Runnable> unfinishedTasks = executorService.shutdownNow();
                log.warn("Оставшиеся задачи: {}", unfinishedTasks.size());
            }
        } catch (InterruptedException e) {
            log.error("Ошибка при завершении ExecutorService: {}", e.getMessage());
            executorService.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}