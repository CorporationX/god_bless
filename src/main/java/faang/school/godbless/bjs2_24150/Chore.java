package faang.school.godbless.bjs2_24150;

import lombok.AllArgsConstructor;

import java.util.Random;

@AllArgsConstructor
public class Chore implements Runnable {
    private static final int MAX_RANDOM_VALUE = 10;

    private String name;

    @Override
    public void run() {
        var stringName = Thread.currentThread().getName();
        System.out.println(stringName + " started doing " + name);
        try {
            Thread.sleep(1000 * (new Random().nextInt(MAX_RANDOM_VALUE) + 1));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(stringName + " completed " + name);
    }
}
