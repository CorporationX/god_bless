package faang.school.godbless.BJS2_6128;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Potion {
    private String name;
    private int requiredIngredients;

    public int gatherIngredients(Potion potion) {
        try {
            Thread.sleep(potion.getRequiredIngredients() * 1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return potion.getRequiredIngredients();
    }
}
