package faang.school.godbless.alexbulgakoff.multithreading.parallelism.threepiglets;

import java.util.Random;

/**
 * @author Alexander Bulgakov
 */

public class Pig1Thread extends PigThread {
    public Pig1Thread(String pigName, int material) {
        super(pigName, material);
    }

    @Override
    public void run() {
        Random random = new Random();
        System.out.println("Поросёнок " + getPigName() + " начал строить дом из " + getMaterial() + " в потоке " + Thread.currentThread().getName());
        try {
            Thread.sleep(random.nextLong(200, 300));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(getPigName() + " построил дом!");
    }
}
