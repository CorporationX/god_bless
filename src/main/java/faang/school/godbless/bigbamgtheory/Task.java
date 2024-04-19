package faang.school.godbless.bigbamgtheory;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor
@Slf4j
public class Task implements Runnable {
    private String name;
    private int task;

    @Override
    public void run() {
        System.out.println("A task " + name + " in progress");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            log.error("Task {} was interrupted", task);
        }
    }
}
