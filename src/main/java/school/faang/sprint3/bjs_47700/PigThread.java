package school.faang.sprint3.bjs_47700;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class PigThread extends Thread {
    private final String pigName;
    private final String material;

    public void buildHouse() {
        System.out.println(pigName + " начал строительство дома из материала " + material);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(pigName + " закончил строительство дома из материала " + material);
    }
}
