package faang.school.godbless.sprint_3.multithreading_future.alchemy_training;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicInteger;

@AllArgsConstructor
@Getter
@Setter
public class Potion {
    private String name;
    private int requiredIngredients;

    public static void main(String[] args) {
        List<Potion> potions = List.of(new Potion("Health potion", 3),
                new Potion("Mana potion", 2),
                new Potion("Alohamora", 5),
                new Potion("Debildorf", 7));
        List<CompletableFuture<Integer>> futures = potions.stream()
                .map(potion -> CompletableFuture.supplyAsync(() -> gatherIngredients(potion)))
                .toList();
        AtomicInteger sum = new AtomicInteger(0);
        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]))
                .thenApply(v -> {
                            sum.set(futures.stream()
                                    .mapToInt(completableFuture -> {
                                        try {
                                            return completableFuture.get();
                                        } catch (InterruptedException | ExecutionException exception) {
                                            exception.printStackTrace();
                                            return 0;
                                        }
                                    })
                                    .sum());
                            return sum;
                        }
                )
                .join();
        System.out.println(sum.get());
    }

    @SneakyThrows
    public static int gatherIngredients(Potion potion) {
        int requiredIngredients = potion.getRequiredIngredients();
        System.out.printf("Пытаемся найти %d ингредиентов для зелья: %s%n", requiredIngredients, potion.getName());
        int waitTime = requiredIngredients * 1000;
        Thread.sleep(waitTime);
        return requiredIngredients;
    }
}