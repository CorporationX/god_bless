package school.faang.BJS2_62541;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class IngredientGatherer {

    public int gatherIngredients(Potion potion) {
        try {
            log.info("Сбор ингредиентов для {}!", potion.getName());
            Thread.sleep(3000);  // Симуляция сбора
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("Сбор ингредиентов для {} был прерван!", potion.getName());
            return 0;
        }

        log.info("Сбор ингредиентов для {} завершен!", potion.getName());
        return potion.getRequiredIngredients();
    }
}
