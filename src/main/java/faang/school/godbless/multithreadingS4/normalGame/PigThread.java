package faang.school.godbless.multithreadingS4.normalGame;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Random;

@Getter
@AllArgsConstructor
public class PigThread extends Thread {
    private final static int COEFF_SLEEP = 1000;
    private String pigName;
    private String material;

    @Override
    public void run() {
        int sleepTime = new Random().nextInt(50) * COEFF_SLEEP;
        System.out.printf("%s began to build a house from %s.\n" +
                "\t\tSleep time %d\n", pigName, material, sleepTime);
        try {
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            System.out.printf("%s has been interrupted.", Thread.currentThread().getName());
        }
        System.out.printf("\t%s finished building the house.\n", pigName);
    }
}
