package school.faang.sprint4.task_64888;

import lombok.RequiredArgsConstructor;
import lombok.Synchronized;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

@RequiredArgsConstructor
@Slf4j
public class Person {
    private static final ExecutorService EXECUTOR = Executors.newFixedThreadPool(5);
    private static final int FIND_INGREDIENT_SEC = 2;
    private static final int FOUND_QUANTITY = 1;

    private final String name;
    private final Map<Potion, Recipe> recipes = new HashMap<>();
    private final ConcurrentHashMap<Ingredient, Integer> ingredients = new ConcurrentHashMap<>();
    private final List<Potion> potions = new ArrayList<>();
    private final List<CompletableFuture<Void>> futures = new ArrayList<>();
    private Map<Ingredient, Integer> missingIngredients;

    @Synchronized
    public void brew(Potion potion) {
        recipes.computeIfAbsent(potion, k -> potion.recipe());
        Recipe recipe = recipes.get(potion);

        if (!recipe.isHasEnoughIngredients(ingredients)) {
            missingIngredients = recipe.getMissingIngredients(ingredients);
            missingIngredients.forEach(((ingredient, count) ->
                    futures.add(CompletableFuture.runAsync(() -> findIngredient(ingredient, count), EXECUTOR))));
        }

        CompletableFuture.allOf(futures.toArray(CompletableFuture[]::new))
                .thenAccept(non -> {
                    log.debug("Found all the missing ingredients");
                    EXECUTOR.shutdownNow();
                    futures.clear();
                }).join();

        potions.add(potion.createPotion(ingredients));
        log.debug("Adding potion {}", potion);
        log.debug("All potions now {}", potions);
    }

    private void findIngredient(Ingredient ingredient, int count) {
        IntStream.range(0, count).forEach(num -> {
            log.debug("Finding an ingredient '{}'", ingredient);
            try {
                TimeUnit.SECONDS.sleep(FIND_INGREDIENT_SEC);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
            ingredients.merge(ingredient, FOUND_QUANTITY, Integer::sum);
        });
    }
}
