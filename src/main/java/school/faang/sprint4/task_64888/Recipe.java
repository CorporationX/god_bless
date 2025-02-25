package school.faang.sprint4.task_64888;

import lombok.RequiredArgsConstructor;
import lombok.Synchronized;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Slf4j
public class Recipe {
    private final Map<Ingredient, Integer> recipe;
    private Map<Ingredient, Integer> ingredients;

    public Map<Ingredient, Integer> getIngredients() {
        return new HashMap<>(recipe);
    }

    @Synchronized
    public boolean isHasEnoughIngredients(Map<Ingredient, Integer> ingredients) {
        log.debug("Checking the availability of all ingredients");
        this.ingredients = ingredients;
        return recipe.entrySet().stream().noneMatch(this::isMissingIngredient);
    }

    @Synchronized
    public Map<Ingredient, Integer> getMissingIngredients(Map<Ingredient, Integer> ingredients) {
        log.debug("Getting the missing ingredients and their quantities");
        this.ingredients = ingredients;
        return recipe.entrySet().stream()
                .filter(this::isMissingIngredient)
                .collect(Collectors.toMap(Map.Entry::getKey, this::getMissingCount));
    }

    private Integer getMissingCount(Map.Entry<Ingredient, Integer> entry) {
        int hasCount = ingredients.getOrDefault(entry.getKey(), 0);
        return entry.getValue() - hasCount;
    }

    private boolean isMissingIngredient(Map.Entry<Ingredient, Integer> entry) {
        return !ingredients.containsKey(entry.getKey()) || ingredients.get(entry.getKey()) < entry.getValue();
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "recipe=" + recipe +
                '}';
    }
}

