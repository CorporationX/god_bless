package school.faang.sprint_4.task_alchemyboostbjs2n50853;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Getter
@AllArgsConstructor
@ToString
@Slf4j
public class Potion {
    @NonNull
    private String name;
    private int requiredIngredients;

    public static synchronized  int gatherIngredients(Potion potion) {
        log.info("'{}' is geathering", potion.name);
        try {
            Thread.sleep(300L * potion.getRequiredIngredients());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return potion.getRequiredIngredients();
    }
}
