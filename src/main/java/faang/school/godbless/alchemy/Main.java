package faang.school.godbless.alchemy;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) {
        AtomicInteger sum = new AtomicInteger();

        List<Potion> potions = Arrays.asList(
                new Potion("Медовуха", 3),
                new Potion("Вишневка", 5),
                new Potion("Малиновка", 6),
                new Potion("Перцовка", 2),
                new Potion("Молотов", 4),
                new Potion("Ягуар", 8)
        );

        List<CompletableFuture<Integer>> futures = potions.stream()
                .map(potion -> CompletableFuture.supplyAsync(() -> gatherIngredients(potion))
                        .thenApply(sum::addAndGet))
                .toList();

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();
        System.out.println("Найдено ингредиентов: " + sum);
    }

    public static int gatherIngredients(Potion potion) {
        try {
            Thread.sleep(2000);
            System.out.println("поток = " + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return potion.getRequiredIngredients();
    }
}

@Getter
@AllArgsConstructor
class Potion {
    private String name;
    private int requiredIngredients;
}