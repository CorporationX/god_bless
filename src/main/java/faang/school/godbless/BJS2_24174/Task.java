package faang.school.godbless.BJS2_24174;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Random;

@Getter
@AllArgsConstructor
public class Task implements Runnable {
    private String name;
    private String task;

    @Override
    public void run() {
        System.out.println(name + " started to do task" + task);

        try {
            Thread.sleep(new Random().nextInt(1000, 10001));
        } catch (InterruptedException e) {
            System.out.println("Task: " + task + " is interrupted");
            return;
        }

        System.out.println(name + " finished to do task " + task);
    }
}
