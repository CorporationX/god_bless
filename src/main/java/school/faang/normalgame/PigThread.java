package school.faang.normalgame;

import lombok.Data;
import lombok.Getter;

@Getter
public class PigThread extends Thread {
    private final String pigName;
    private final String material;

    public PigThread(String pigName, String material) {
        this.pigName = pigName;
        this.material = material;
    }

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
