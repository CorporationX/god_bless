package school.faang.alchemy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final ExecutorService service = Executors.newFixedThreadPool(2);
    private static final Logger log = LoggerFactory.getLogger(Main.class);
    private static final int THREAD_SLEEP_TIME = 4000;
    private static final int TIME_AWAIT_TERMINATION = 20;

    public static void main(String[] args) {
        List<Potion> potions = List.of(
                new Potion("Healing Potion", 5),
                new Potion("Mana Potion", 3),
                new Potion("Stamina Potion", 4)
        );

        gatherAllIngredients(potions);

        service.shutdown();
        try {
            if (!service.awaitTermination(TIME_AWAIT_TERMINATION, TimeUnit.SECONDS)) {
                service.shutdownNow();
                System.err.println("Не удалось завершить все задачи за 20 секунд");
            }
        } catch (InterruptedException e) {
            log.error("Прерывание ожидания завершения задач: {}", e.getMessage());
            Thread.currentThread().interrupt();
        }
    }

    public static void gatherAllIngredients(List<Potion> potions) {
        List<CompletableFuture<Integer>> futures = potions.stream()
                .map(Main::gatherIngredients)
                .toList();

        CompletableFuture<Void> allCompleted =
                CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));

        allCompleted.thenRun(() -> {
            int totalIngridients = futures.stream()
                    .mapToInt(CompletableFuture::join)
                    .sum();
            System.out.println("Общее количество собранных ингредиентов: "
                    + totalIngridients);
        });
    }

    public static CompletableFuture<Integer> gatherIngredients(Potion potion) {
        return CompletableFuture.supplyAsync(() -> {
            threadSleep();
            return potion.getRequiredIngredients();
        }, service);
    }

    public static void threadSleep() {
        try {
            Thread.sleep(THREAD_SLEEP_TIME);
        } catch (InterruptedException e) {
            log.warn("Thread interrupted during sleep: ", e);
        }
    }
}
