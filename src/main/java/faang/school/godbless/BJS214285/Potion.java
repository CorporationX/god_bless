package faang.school.godbless.BJS214285;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Potion {
    private static long DELAY_TIME = 1000;

    private String name;
    private int requiredIngredients;

    public  void gatherIngredients(ResultIngredientsCounter result)  {
        try {
            Thread.sleep(DELAY_TIME);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            result.add(this.getRequiredIngredients());
        }
    }
}
