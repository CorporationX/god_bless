package school.faang.fourthStream.BJS2_38743;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@AllArgsConstructor
@Slf4j
public class Potion {
    private static final long THREAD_SLEEP_TIME = 1000;
    private final String name;
    private int requiredIngredients;

    public int gatherIngredients() {
        try {
            Thread.sleep(this.requiredIngredients * THREAD_SLEEP_TIME);
        } catch (InterruptedException e) {
            log.warn("Упс.. Сбор ингридиентов для зелья {} был прерван\n Причина:\n{}", this.name, e.getMessage());
        }

        log.info("{} ингредиентов собрано для {}\n", this.requiredIngredients, this.name);
        return this.requiredIngredients;
    }
}
