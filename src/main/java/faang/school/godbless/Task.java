package faang.school.godbless;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Random;

@Data
@AllArgsConstructor
public class Task implements Runnable {
    private String name;
    private String task;

    @Override
    public void run() {
        try {
            System.out.println(task + "is started by " + name + " " + Thread.currentThread().getName());
            Thread.sleep(new Random().nextInt(1000, 5000));
            System.out.println("Task is done");
        } catch (InterruptedException e) {
            System.out.println("Task has been interrupted");
            Thread.currentThread().interrupt();
        }
    }
}
