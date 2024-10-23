package school.faang.task414.potion;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Potion {
    private String name;
    private int requiredIngredients;

    public int gatherIngredients() {
        try {
            Thread.sleep(2000);
            return requiredIngredients;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
