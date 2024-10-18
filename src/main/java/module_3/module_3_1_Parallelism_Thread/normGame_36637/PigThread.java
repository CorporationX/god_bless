package module_3.module_3_1_Parallelism_Thread.normGame_36637;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PigThread extends Thread {
    private final String pigName;
    private final String material;

    public void buildHouse(int delay) {
        System.out.println(pigName + " строит дом из " + material);
        try {
            Thread.sleep(delay);
            System.out.println(getPigName() + " завершил строительство своего дома из " + getMaterial());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
