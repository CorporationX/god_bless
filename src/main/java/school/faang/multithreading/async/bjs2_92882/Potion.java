package school.faang.multithreading.async.bjs2_92882;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public record Potion(String name, int numberIngredients) {

    public int getRequiredIngredients() {
        log.info("Сбор ингредиентов для '{}' закончен, их количество: {}", name, numberIngredients);
        return numberIngredients;
    }
}
