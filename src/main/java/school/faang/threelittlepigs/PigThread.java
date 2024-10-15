package school.faang.threelittlepigs;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class PigThread extends Thread{
    private String pigName;
    private String material;

    public void buildHouse(int delay) {
        System.out.println(getPigName() + " начал строить дом из " + getMaterial());
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(getPigName() + " закончил строить дом из " + getMaterial());
    }
}
