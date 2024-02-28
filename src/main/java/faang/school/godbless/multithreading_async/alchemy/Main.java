package faang.school.godbless.multithreading_async.alchemy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        Potion potion1 = new Potion("Ускорение", 5);
        Potion potion2 = new Potion("Прыжок", 3);
        Potion potion3 = new Potion("Регенерация", 5);
        Potion potion4 = new Potion("Урон", 4);
        Potion potion5 = new Potion("Ловкость", 2);

        List<Potion> potionList = new ArrayList<>(Arrays.asList(potion2, potion1, potion3, potion4, potion5));

        List<CompletableFuture<Integer>> futures = potionList.stream()
                .map(Potion::gatherIngredients)
                .toList();

        CompletableFuture<Void> allFuture = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));
        allFuture.thenRun(() -> {
            int sum = futures.stream()
                    .mapToInt(CompletableFuture::join) // Преобразование CompletableFuture в int
                    .sum(); // Вычисление суммы всех элементов
            System.out.println("Общее количество собранных ингредиентов" + sum);
        }).join();

    }
}
