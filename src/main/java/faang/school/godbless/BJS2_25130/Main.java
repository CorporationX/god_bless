package faang.school.godbless.BJS2_25130;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    private static final AtomicInteger totalIngredients = new AtomicInteger(0);

    public static void main(String[] args) {
        List<Potion> potions = List.of(
                new Potion("Зелье красоты", 5),
                new Potion("Зелье здоровья", 3),
                new Potion("Зелье силы", 7),
                new Potion("Зелье ловкости", 4)
        );

        CompletableFuture<Void> allTasks = CompletableFuture.allOf(
                potions.stream()
                        .map(Main::gatherIngredients)
                        .map(future -> future.thenApply(totalIngredients::addAndGet))
                        .toArray(CompletableFuture[]::new)
        );

        allTasks.thenRun(() -> System.out.println("Общее количество собранных ингредиентов: " + totalIngredients.get())).join();
    }
    public static CompletableFuture<Integer> gatherIngredients(Potion potion) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println("Начинаем собирать ингредиенты для зелья: " + potion.getName());
                TimeUnit.SECONDS.sleep(potion.getRequiredIngredients() * 2L);
                System.out.println("Собрали ингредиенты для зелья: " + potion.getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return potion.getRequiredIngredients();
        });
    }
}
