package faang.school.godbless.ImproveAlchemy;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Potion {
    private String name;
    private int requiredIngredients;

    public int gatherIngredients() {
        try {
            Thread.sleep(100L * requiredIngredients);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return requiredIngredients;
    }
}
