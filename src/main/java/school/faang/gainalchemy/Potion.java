package school.faang.gainalchemy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@AllArgsConstructor
@Slf4j
public class Potion {
    private static final Integer SLEEP_TIME = 10000;

    private String name;
    private Integer requiredIngredients;

    public static Integer gatherAllIngredients(Potion potion) {
        System.out.println("Старт сбора ингридиентов для: " + potion.name);
        try {
            Thread.sleep(SLEEP_TIME);
        } catch (InterruptedException e) {
            log.error(e.getMessage());
            throw new IllegalStateException("Ошибка в пооке " + e.getMessage());
        }

        return potion.requiredIngredients;
    }
}
