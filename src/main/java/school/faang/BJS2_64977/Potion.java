package school.faang.BJS2_64977;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor
@Getter
@Slf4j
public class Potion {
    private final String name;
    private final int requiredIngredients;

    public static int requiredIngredients(Potion potion) {
        log.info("Начался сбор ингредиентов для зелья {} ({} шт.)",
                potion.getName(), potion.getRequiredIngredients()
        );

        try {
            Thread.sleep(potion.getRequiredIngredients() * 1000L);
        } catch (Exception e) {
            log.error("Ошибка при сборе ингредиентов для {}", potion.getName(), e);
            Thread.currentThread().interrupt();
        }

        log.info("Зелье {} собрано! ({} ингредиентов)",
                potion.getName(), potion.getRequiredIngredients()
        );

        return potion.getRequiredIngredients();
    }

}
