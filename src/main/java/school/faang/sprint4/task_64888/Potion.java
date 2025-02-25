package school.faang.sprint4.task_64888;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ConcurrentHashMap;

@Slf4j
public record Potion(String name, Recipe recipe) {
    public Potion createPotion(ConcurrentHashMap<Ingredient, Integer> ingredients) {
        log.debug("Creating potion");
        log.debug("Needing ingredients is {}", recipe);
        log.debug("Has ingredients {}", ingredients);
        recipe.getIngredients().forEach((ingredient, count) -> {
            ingredients.compute(ingredient, (key, hasCount) -> hasCount - count);
            if (ingredients.get(ingredient) == 0) {
                ingredients.remove(ingredient);
            }
        });
        log.debug("All ingredients are now  {}", ingredients);
        return this;
    }

    @Override
    public String toString() {
        return "'" + name + "'";
    }
}

