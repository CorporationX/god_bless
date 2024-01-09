package faang.school.godbless.alexbulgakoff.multithreading.parallelism.threepiglets;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.Random;

/**
 * @author Alexander Bulgakov
 */

@AllArgsConstructor
@Getter
@ToString
public class PigThread extends Thread {
    private String pigName;
    private int material;

    @Override
    public void run() {
        Random random = new Random();
        System.out.println("Поросёнок " + getPigName() + " начал строить дом из " + getMaterial() +
                " в потоке " + Thread.currentThread().getName());
        try {
            Thread.sleep(random.nextLong(200, 300));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(getPigName() + " построил дом!");
    }
}
