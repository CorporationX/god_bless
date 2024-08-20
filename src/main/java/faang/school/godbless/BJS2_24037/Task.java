package faang.school.godbless.BJS2_24037;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Random;

@AllArgsConstructor
@Getter
public class Task implements Runnable{
    private final String name;
    private final String task;
    private final Random random = new Random();

    @Override
    public void run() {
        System.out.printf("%s starts the task (%s)\n", name, task);
        try {
            Thread.sleep(getMilliseconds());
        } catch (InterruptedException e) {
            System.out.printf("%s interrupts the task (%s)\n", name, task);
            return;
        }
        System.out.printf("%s ends the task (%s)\n", name, task);
    }

    private int getMilliseconds() {
        return (random.nextInt(5) + 1) * 1000;
    }
}
