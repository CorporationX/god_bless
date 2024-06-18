package faang.school.godbless.BJS2_12342;

import lombok.AllArgsConstructor;

import java.util.Random;
import java.util.concurrent.TimeUnit;

@AllArgsConstructor
public class Task implements Runnable {
    private String name;
    private String task;

    @Override
    public void run() {
        System.out.println(name + " have just started to implement his task: " + task + " is in the progress");
        try {
            TimeUnit.SECONDS.sleep(new Random().nextInt(20));
            System.out.println(name + " has accomplished his task: " + task);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
