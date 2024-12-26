package school.faang.task_50794;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Slf4j
public class Main {
    public static void main(String[] args) {
        List<Potion> potions = List.of(
                new Potion("Healing Potion", 5),
                new Potion("Mana Potion", 3),
                new Potion("Stamina Potion", 4)
        );

        Integer countIngredients = countAllIngredients(potions);
        log.info("Gathered ingredients: {}", countIngredients);
    }

    private static Integer countAllIngredients(List<Potion> potions) {
        return potions.stream()
                .map(Main::gatherIngredients)
                .map(CompletableFuture::join)
                .reduce(0, Integer::sum);
    }

    private static CompletableFuture<Integer> gatherIngredients(Potion potion) {
        log.info("Start gathering ingredients for potion: {}...", potion.getName());
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1_000);
            } catch (InterruptedException e) {
                log.error("Error interrupted: {}", e.getMessage());
                throw new RuntimeException(e);
            }
            return potion.getRequiredIngredients();
        });
    }
}
