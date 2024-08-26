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
        try {
            System.out.printf("%s started to do task %s%n", name, task);
            Thread.sleep(new Random().nextInt(1000, 10001));
            System.out.printf("%s finished to do task %s%n", name, task);
        } catch (InterruptedException e) {
            System.out.println("Error");
            Thread.currentThread().interrupt();
        }
    }
}