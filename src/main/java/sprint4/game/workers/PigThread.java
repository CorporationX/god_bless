package sprint4.game.workers;

import lombok.Data;
import lombok.EqualsAndHashCode;
import sprint4.game.Material;

@Data
@EqualsAndHashCode(callSuper = true)
public abstract class PigThread extends Thread {
    protected static final int MAX_PERCENTAGE = 100;
    protected int improvedCompleteness;
    protected String pigName;
    protected Material material;

    public PigThread(String pigName, Material material, int improvedCompleteness) {
        this.pigName = pigName;
        this.material = material;
        this.improvedCompleteness = improvedCompleteness;
    }

    @Override
    public void run() {
        System.out.printf("ѕоросенок %s начинает строить дом из %s\n", pigName, material);
        for (int percentage = improvedCompleteness; percentage <= MAX_PERCENTAGE; percentage += improvedCompleteness) {
            System.out.printf("—троительство дома из %s завершено на %d\n", material, percentage);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.out.printf("ѕоросенок %s заснул и не смог построить дом\n", pigName);
            }
        }
        System.out.printf("—троительство дома из %s поросенка %s завершено!\n", material, pigName);
    }
}
