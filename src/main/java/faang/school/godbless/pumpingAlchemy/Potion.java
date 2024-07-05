package faang.school.godbless.pumpingAlchemy;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Potion {
    private String name;
    private int requiredIngredients;

    public int gatherIngredients(Potion potion) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(potion.getName());
        return getRequiredIngredients();
    }

    public int getRequiredIngredients() {
        return requiredIngredients;
    }
}
