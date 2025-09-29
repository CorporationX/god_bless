package bjs2_91297;

import lombok.Getter;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Getter
public class PigThread extends Thread {
    private final String pigName;
    private final String material;
    private final int buildTime;

    @Override
    public void run() {
        System.out.printf("%s начал строить дом из %s%n", pigName, material);
        try {
            Thread.sleep(buildTime);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.printf("%s был прерван во время строительства!%n", pigName);
            return;
        }
        System.out.printf("%s закончил строить дом из %s%n", pigName, material);
    }
}