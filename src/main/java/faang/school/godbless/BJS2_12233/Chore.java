package faang.school.godbless.BJS2_12233;

import lombok.AllArgsConstructor;

import java.util.Random;
import java.util.concurrent.TimeUnit;

@AllArgsConstructor
public class Chore implements Runnable {
    private String name;

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " is working on " + name);
        try {
            TimeUnit.SECONDS.sleep(new Random().nextInt(15));
            System.out.println(Thread.currentThread().getName() + " finished working on " + name);
        } catch (InterruptedException e) {
            e.getStackTrace();
        }
    }
}
