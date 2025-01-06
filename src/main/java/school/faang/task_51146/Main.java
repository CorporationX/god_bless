package school.faang.task_51146;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Slf4j
public class Main {
    public static CompletableFuture<Integer> gatherIngredients(Potion potion) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(potion.getRequiredIngredients() * 1000);
            } catch (InterruptedException e) {
                log.warn("Ошибка: {1}", e);
                throw new RuntimeException(e);
            }
            return potion.getRequiredIngredients();
        });
    }

    public static void main(String[] args) {
        List<Potion> potions = List.of(
                new Potion("Healing Potion", 5),
                new Potion("Mana Potion", 11),
                new Potion("Stamina Potion", 4)
        );

        List<CompletableFuture<Integer>> gatherAllIngredients = potions.stream()
                .map(potion -> gatherIngredients(potion)).collect(Collectors.toList());

        CompletableFuture<Void> allPotion = CompletableFuture.allOf(gatherAllIngredients
                .toArray(new CompletableFuture[0]));

        AtomicInteger allIngredients = new AtomicInteger(0);
        for (CompletableFuture<Integer> future : gatherAllIngredients) {
            allIngredients.addAndGet(future.join());
        }
        System.out.println("Общее количество собранных ингредиентов: " + allIngredients);
    }
}

