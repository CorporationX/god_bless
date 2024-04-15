package theBigBangTheory;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Random;

@AllArgsConstructor
@Data
public class Task implements Runnable {
    private String name;
    private String task;

    @Override
    public void run() {
        System.out.println(String.format("%s start task %s", this.name, this.task));
        try {
            Thread.sleep(new Random().nextInt(1, 5));
        } catch (InterruptedException e) {
            throw new RuntimeException("Task task interrupted: " + e.getMessage());
        }
        System.out.println(String.format("%s completed the task: \"%s\"", this.name, this.task));
    }
}
