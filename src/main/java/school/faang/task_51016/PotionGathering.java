package school.faang.task_51016;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Slf4j
public class PotionGathering {

    public static AtomicInteger atomicInteger = new AtomicInteger(0);

    public static void main(String[] args) {
        List<Potion> potions = List.of(
                new Potion("Healing Potion", 5),
                new Potion("Mana Potion", 3),
                new Potion("Stamina Potion", 4)
        );

        potions.stream()
                .map(potion -> gatherIngredients(potion))
                .collect(Collectors.toList())
                .forEach(future -> atomicInteger.addAndGet(future.join()));

        int result = atomicInteger.get();
        System.out.println("Общее количество собранных ингредиентов: " + result);

    }

    public static CompletableFuture<Integer> gatherIngredients(Potion potion) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1_000);
            } catch (InterruptedException e) {
                log.error("Ошибка сбора: " + e);
                throw new RuntimeException(e);
            }
            return potion.getRequiredIngredients();
        });
    }
}
