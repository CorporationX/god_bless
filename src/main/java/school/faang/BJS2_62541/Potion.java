package school.faang.BJS2_62541;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Getter
@Slf4j
public class Potion {

    private final String name;
    private final int requiredIngredients;

    public int gatherIngredients(Potion potion) {
        try {
            log.info("Сбор ингредиентов для {}!", potion.getName());
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        log.info("Сбор ингредиентов для {} завершен!", potion.getName());

        return potion.getRequiredIngredients();
    }
}
