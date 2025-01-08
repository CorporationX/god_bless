package school.faang.moduleone.sprintfour.task_43583;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class PotionGathering {
    private static ExecutorService executor = Executors.newFixedThreadPool(3);

    public static void main(String[] args) {
        List<Potion> potions = List.of(
                new Potion("Healing Potion", 5),
                new Potion("Mana Potion", 3),
                new Potion("Stamina Potion", 4)
        );

        int totalIngredientsSum = gatherAllIngredients(potions);
        log.info("total ingredients sum = {}", totalIngredientsSum);

        shutdownGracefully(executor);
    }

    private static int gatherAllIngredients(List<Potion> potions) {
        AtomicInteger totalIngredients = new AtomicInteger(0);
        CompletableFuture.allOf(potions.stream()
                .map(potion -> gatherIngredients(potion)
                        .thenAccept(totalIngredients::addAndGet))
                .toArray(CompletableFuture[]::new)
        ).join();
        return totalIngredients.get();
    }

    private static CompletableFuture<Integer> gatherIngredients(Potion potion) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                log.error("Поток {} был прерван во время исполнения", Thread.currentThread().getName());
                throw new RuntimeException(e);
            }
            return potion.getRequiredIngredients();
        }, executor);
    }

    private static void shutdownGracefully(ExecutorService executor) {
        executor.shutdown();
        try {
            if (!executor.awaitTermination(5, TimeUnit.SECONDS)) {
                log.error("часть потоков не завершили задачи в отведенное время. Останавливаем принудительно");
                executor.shutdownNow();
            }
            log.info("Все потоки завершились успешно");
        } catch (InterruptedException e) {
            log.error("Корректное завершение потоков было прервано. Останавливаем принудительно");
            executor.shutdownNow();
        }
    }
}
