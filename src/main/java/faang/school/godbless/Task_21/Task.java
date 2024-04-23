package faang.school.godbless.Task_21;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Task implements Runnable {
    String name;
    String task;

    @Override
    public void run() {
        System.out.println("Task " + task + " started");
        try {
            Thread.sleep(300);
            System.out.println(task + " finished");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
