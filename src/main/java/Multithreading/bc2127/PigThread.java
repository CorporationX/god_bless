package Multithreading.bc2127;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class PigThread extends Thread {
    private String pigName;
    private int material;

    @Override
    public void run() {
        try {
            System.out.println("Для поросенка: " + getPigName() + " начали строить дом из материала: " + getMaterial());
            Thread.sleep(3000);
            System.out.println("Строительство дома для " + getPigName() + " закончено");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
