package school.faang.sprint4.potion;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@RequiredArgsConstructor
public class PotionGathering {

    private static final Integer TIME_AWAIT_SECONDS = 5;

    private static final ExecutorService executorService = Executors.newFixedThreadPool(8);

    public static void gatherAllIngredients(List<Potion> potions) {

        AtomicInteger allIngredients = new AtomicInteger();

        List<CompletableFuture<Integer>> futures = potions
                .stream()
                .map(potion -> CompletableFuture.supplyAsync(
                        () -> allIngredients.addAndGet(potion.getIngredients()), executorService))
                .toList();

        CompletableFuture.allOf(futures.toArray(CompletableFuture[]::new))
                .join();

        System.out.println(allIngredients.get());
        end();
    }

    public static void end() {
        executorService.shutdown();
        try {
            if (executorService.awaitTermination(TIME_AWAIT_SECONDS, TimeUnit.SECONDS)) {
                System.out.println("Потоки завершили работу");
            } else {
                System.out.println("Ошибка ожидания окончания работы потоков");
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            System.out.println("Прерывание ожидания окончания работы потоков");
            Thread.currentThread().interrupt();
        }
    }

    public static void main(String[] args) {
        List<Potion> potions = List.of(
                new Potion("Healing Potion", 5),
                new Potion("Mana Potion", 3),
                new Potion("Stamina Potion", 4)
        );
        gatherAllIngredients(potions);
    }

}
