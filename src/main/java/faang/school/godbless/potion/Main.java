package faang.school.godbless.potion;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    private static final int NUM_THREAD = 5;

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREAD);
        CopyOnWriteArrayList<String> ingredientsPantry =
                new CopyOnWriteArrayList<>(Potion.generateThirtyIngredientsInPantry());
        List<CompletableFuture<String>> futures = new ArrayList<>();
        // Хочу чтобы добавление в лист было в стреме и получить лист комплетабле с джэнериком строка
        Potion.generateFivePotion().forEach(potion -> futures.add(CompletableFuture.supplyAsync(potion.gatherIngredients(ingredientsPantry))));
        // После стрима добавление в общий CompletableFuture где он выводит рультат каждого из значение в колнсоль
        executor.shutdown();
    }
}
