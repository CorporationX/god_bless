package school.faang.task_50816;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.ExecutorService;

@Slf4j
public class Main {
    public static void main(String[] args) {
        ExecutorService executorService = ExecutorServiceFactory.createExecutorService();
        PotionGathering potionGathering = new PotionGathering(executorService);

        List<Potion> potions = PotionFactory.createPotions();

        potionGathering.gatherAllIngredientsAsync(potions)
                .thenAccept(totalIngredients
                        -> log.info("Общее количество собранных ингредиентов: {}", totalIngredients))
                .join();

        shutdownExecutorService(executorService);
    }

    private static void shutdownExecutorService(ExecutorService executorService) {
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(Constants.AWAIT_TERMINATION_TIMEOUT.getValue(),
                    java.util.concurrent.TimeUnit.SECONDS)) {
                log.warn("Потоки не завершились вовремя. Принудительное завершение.");
                List<Runnable> unfinishedTasks = executorService.shutdownNow();
                log.warn("Оставшиеся задачи: {}", unfinishedTasks.size());
            }
        } catch (InterruptedException e) {
            log.error("Ошибка при завершении ExecutorService: {}", e.getMessage());
        }
    }
}