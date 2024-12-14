package school.faang.train_alchemic.main_code;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class PotionService {
    public void getAllIngredients(List<Potion> potions) {
        List<CompletableFuture<Integer>> futures = potions.stream()
                .map(this::gatherIntredients)
                .collect(Collectors.toList());

        CompletableFuture<Void> allIngredients =
                CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));

        allIngredients.thenRun(() -> {
            AtomicInteger totalIngredients = new AtomicInteger(0);
            futures.forEach(future -> totalIngredients.addAndGet(future.join()));
            System.out.println("Общее количество собранных ингредиентов " + totalIngredients);
        });

        allIngredients.join();
    }

    private CompletableFuture<Integer> gatherIntredients(Potion potion) {
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException("Ошибка при попытке получить инредиент " + e);
            }

            return potion.getRequiredIngredients();
        });

        return future;
    }
}
