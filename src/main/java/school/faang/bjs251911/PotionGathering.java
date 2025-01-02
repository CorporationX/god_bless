package school.faang.bjs251911;

import lombok.extern.slf4j.Slf4j;
import lombok.val;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class PotionGathering {

    public static final int TIME_PROCESS = 2000;

    public static void main(String[] args) {
        val potions = List.of(
                new Potion("Healing Potion", 5),
                new Potion("Mana Potion", 3),
                new Potion("Stamina Potion", 4)
        );
        gatherAllIngredients(potions);
    }

    private static void gatherAllIngredients(List<Potion> potions) {
        val totalIngredients = new AtomicInteger(0);

        List<CompletableFuture<Integer>> futures = potions.stream()
                .map(PotionGathering::gatherIngredients)
                .toList();

        futures.forEach(future -> totalIngredients.addAndGet(future.join()));

        val total = totalIngredients.get();
        System.out.println("Общее количество собранных ингредиентов: " + total);
    }

    private static CompletableFuture<Integer> gatherIngredients(Potion potion) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(TIME_PROCESS);
            } catch (InterruptedException ex) {
                log.error("The task has been aborted!{}", String.valueOf(ex));
                Thread.currentThread().interrupt();
                throw new RuntimeException();
            }
            return potion.getRequiredIngredients();
        });
    }
}
