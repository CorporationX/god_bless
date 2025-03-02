package BJS262501;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
@AllArgsConstructor
public class Potion {
    private final String name;
    private int requiredIngredients;

    public Integer gatherIngredients(Potion potion) {
        try {
            Thread.sleep(potion.getRequiredIngredients() * 500L);
        } catch (InterruptedException e) {
            log.error("Can`t collect ingredients!");
            log.error(e.getMessage(), e);
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
        return potion.getRequiredIngredients();
    }
}
