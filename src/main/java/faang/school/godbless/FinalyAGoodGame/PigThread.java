package faang.school.godbless.FinalyAGoodGame;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
abstract class PigThread extends Thread {
    protected String pigName;
    protected int material;

    public void buildHouse()
    {
        System.out.println(pigName + " building house from material " + material);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(pigName + " finished building house from material " + material);
    }
}
