package school.faang.sprint4.potion;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class Potion {

    private static final Integer TIME_SLEEP_INTERVAL_SECONDS = 10;

    private final String name;
    private final int ingredients;

    public int gatherAllIngredients() {
        try {
            Thread.sleep(TIME_SLEEP_INTERVAL_SECONDS);
            return ingredients;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
