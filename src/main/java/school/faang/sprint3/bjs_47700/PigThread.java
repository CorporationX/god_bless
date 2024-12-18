package school.faang.sprint3.bjs_47700;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class PigThread extends Thread {
    private static final int DELAY = 2000;

    private final String pigName;
    private final String material;

    public void buildHouse() {
        System.out.println(pigName + " начал строительство дома из материала " + material);
        try {
            Thread.sleep(DELAY);
        } catch (InterruptedException e) {
            System.out.println("Поток был прерван");
            Thread.currentThread().interrupt();
        }
        System.out.println(pigName + " закончил строительство дома из материала " + material);
    }
}
