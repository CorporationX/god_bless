package faang.school.godbless.BJS2_24301;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Random;

@Getter
@AllArgsConstructor
public class Chore implements Runnable {
    private String taskName;

    @Override
    public void run() {
        try {
            System.out.printf("Task %s is running by %s%n", taskName, Thread.currentThread().getName());
            Thread.sleep(new Random().nextInt(5000, 10001));
            System.out.printf("Task %s completed%n", taskName);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
            Thread.currentThread().interrupt();
        }
    }
}
