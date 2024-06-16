package faang.school.godbless.multithreading;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Task implements Runnable {

    private static final int SLEEP_TIME = 2000;

    private String name;
    private String task;

    @Override
    public void run() {
        System.out.println(name + ": the task is start");
        try {
            Thread.sleep(SLEEP_TIME);
        } catch (InterruptedException e) {
            System.out.println("The task is interrupted");
            throw new RuntimeException(e);
        }
        System.out.println(name + ": the task is end");
    }
}
