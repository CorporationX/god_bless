package school.faangSprint3.t17;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PigThread extends Thread {
    private final String pigName;
    private final String material;

    protected void buildHouse(int delay) {
        System.out.println(getPigName() + " начал строить дом из материала: " + getMaterial());
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(getPigName() + " закончил строить дом из материала: " + getMaterial());
    }
}